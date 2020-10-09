package com.techelevator.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

@Component
public class JDBCItineraryDAO implements ItineraryDAO {
	
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	private Long currentUserId;
	private LandmarkDAO landmarkDAO;
	
	public JDBCItineraryDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void createItinerary(Itinerary itinerary) {
		String name = itinerary.getName();
		String startingLocation = itinerary.getStartingLocation();
		LocalDate date = itinerary.getDate();
		
		//works if the logged in user creates a itinerary, otherwise need a new way to retrieve the logged in user's name to get the id
		currentUserId = (long) userDAO.findIdByUsername(itinerary.getUsername());
		
		String sql = "INSERT INTO itinerary(name, starting_point, date, user_id)"
				+ " VALUES (?, ?, ?, ?) RETURNING itinerary_id";
		SqlRowSet itinerarySql = jdbcTemplate.queryForRowSet(sql, name, startingLocation, date, currentUserId);
		
		Long itineraryId = 0L;
		
		if (itinerarySql.next()) {
			itineraryId = itinerarySql.getLong("itinerary_id");
		}
		
		List<Landmark> destinations = itinerary.getDestinations();
		
		String destinationInsert = "INSERT INTO destinations(itinerary_id, landmark_id) VALUES (? ,?)";
		
		for (Landmark landmark : destinations) {
			jdbcTemplate.update(destinationInsert, itineraryId, landmark.getId());
		}
		
	}

	@Override
	public List<Itinerary> retrieveAllUserItinerary(String username) {
		String sql = "SELECT * FROM itinerary WHERE user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, currentUserId);
		List<Itinerary> output = new ArrayList<>();
		
		while(result.next()) {
			Itinerary itinerary = new Itinerary();
			itinerary.setItineraryId(result.getLong("itinerary_id"));
			itinerary.setName(result.getString("name"));
			itinerary.setStartingLocation(result.getString("starting_point"));
			itinerary.setDestinations(retrieveItineraryLandmarks(result.getLong("id")));
			itinerary.setDate(result.getDate("date_of").toLocalDate());
			itinerary.setUserId(result.getLong("user_id"));
			output.add(itinerary);
		}
		return output;
	}
	
	@Override
	public List<Itinerary> retrieveSharedItineraries(String username) {
		List<Itinerary> output = new ArrayList<>();
		List<Long> itineraryIds = new ArrayList<>();
		
		String sql = "SELECT * FROM accessibility WHERE user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, currentUserId);
		
		while (result.next() ) {
			Long id = result.getLong("itinerary_id");
			itineraryIds.add(id);
		}
		
		for (Long id : itineraryIds) {
			output.add(retrieveItinerary(id));
		}
		
		return output;
	}
	
	@Override
	public Itinerary retrieveItinerary(Long id) {
		String sql = "SELECT * FROM itinerary WHERE itinerary_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		Itinerary itinerary = new Itinerary();
		
		while(result.next()) {
			itinerary.setItineraryId(result.getLong("itinerary_id"));
			itinerary.setName(result.getString("name"));
			itinerary.setStartingLocation(result.getString("starting_location"));
			itinerary.setDestinations(retrieveItineraryLandmarks(result.getLong("id")));
			itinerary.setDate(result.getDate("date_of").toLocalDate());
			itinerary.setUserId(result.getLong("user_id"));
		}
		
		return itinerary;
	}
	
	@Override
	public List<Landmark> retrieveItineraryLandmarks(Long itineraryID){
		List<Landmark> output = new ArrayList<Landmark>();
		String sql = "SELECT landmark_id FROM destinations WHERE itineraryID = ?";
		
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, itineraryID);
		
		List<Long> landmarkIDs = new ArrayList<Long>();
		
		while(row.next()) {
			Long landmarkID = row.getLong("landmark_id");
			landmarkIDs.add(landmarkID);
		}
		
		for (Long landmarkID : landmarkIDs) {
			output.add(landmarkDAO.getLandmarkById(landmarkID));
		}
		return output;
	}

	@Override
	public void updateItinerary(Itinerary itinerary, Long id, String username) {
		if (itinerary.getUsername().equals(username)) {
		String sql = "UPDATE itinerary SET name = ?, starting_point = ?, date_of = ? WHERE itinerary_id = ?";
		String name = itinerary.getName();
		String startingLocation = itinerary.getStartingLocation();
		LocalDate date = itinerary.getDate();
		
		jdbcTemplate.update(sql, name, startingLocation, date, id);
		
		jdbcTemplate.update("DELETE FROM destinations WHERE itinerary_id = ?", id);
		
		for (Landmark landmark : itinerary.getDestinations()) {
			String destination = "INSERT INTO destinations(itinerary_id, landmark_id) VALUES (?, ?)";
			jdbcTemplate.update(destination, id, landmark.getId());
		}
		}
	}

	@Override
	public void deleteItinerary(Long itineraryId, String username) {
		if (retrieveItinerary(itineraryId).getUsername().equals(username)) {
		
			String sql = "DELETE FROM itinerary WHERE itinerary_id = ?";
			String destinationDelete = "DELETE FROM destinations WHERE itinerary_id=?";
			String sqlAccessibility = "DELETE FROM accessibility WHERE itinerary_id = ?";
			
			jdbcTemplate.update(sql, itineraryId);
			jdbcTemplate.update(destinationDelete, itineraryId);
			jdbcTemplate.update(sqlAccessibility, itineraryId);
		}
	}

	@Override
	public void shareItinerary(Long itineraryId, String shareUsername, String username) {
		if (retrieveItinerary(itineraryId).getUsername().equals(username)) {
			String sql = "INSERT INTO accessibility(itinerary_id, user_id)";
			
			jdbcTemplate.update(sql, itineraryId, userDAO.findIdByUsername(shareUsername));
		}
	}
	
	@Override
	public void removeSharedItinerary(Long itineraryId, String shareUsername, String username) {
		if (retrieveItinerary(itineraryId).getUsername().equals(username)) {
			String sql = "DELETE FROM accessibility WHERE itinerary_id = ? AND user_id = ?";
			
			jdbcTemplate.update(sql, itineraryId, userDAO.findIdByUsername(shareUsername));
		}
	}
}
