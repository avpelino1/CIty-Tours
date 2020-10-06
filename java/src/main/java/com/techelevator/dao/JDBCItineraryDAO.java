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
	
	private JdbcTemplate jdbc;
	
	public JDBCItineraryDAO(DataSource datasource) {
		jdbc = new JdbcTemplate(datasource);
	}

	@Override
	public void createItinerary(Itinerary itinerary) {
		String name = itinerary.getName();
		String startingLocation = itinerary.getStartingLocation();
		List<Landmark> destinations = itinerary.getDestinations();
		LocalDate date = itinerary.getDate();
		Long userId = itinerary.getUserId();
		
		String sql = "INSERT INTO itinerary(name, starting_location, destinations, date, user_id)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbc.update(sql, name, startingLocation, destinations, date, userId);
		
	}

	@Override
	public List<Itinerary> retrieveAllItinerary() {
		String sql = "SELECT * FROM itinerary";
		SqlRowSet result = jdbc.queryForRowSet(sql);
		List<Itinerary> output = new ArrayList<>();
		
		while(result.next()) {
			Long id = result.getLong("itinerary_id");
			String name = result.getString("name");
			String startingLocation = result.getString("starting_location");
			List<Landmark> destinations = retrieveItineraryLandmarks(id);
			LocalDate date = result.getDate("date_of").toLocalDate();
			Long userId = result.getLong("user_id");
			
			Itinerary itinerary = new Itinerary(id, name, startingLocation, destinations, date, userId);
			output.add(itinerary);
		}
		return output;
	}
	
	@Override
	public List<Landmark> retrieveItineraryLandmarks(Long itineraryID){
		List<Landmark> output = new ArrayList<Landmark>();
		String sql = "SELECT landmark_id FROM destinations WHERE itineraryID = ?";
		SqlRowSet row = jdbc.queryForRowSet(sql, itineraryID);
		List<Long> landmarkIDs = new ArrayList<Long>();
		while(row.next()) {
			Long landmarkID = row.getLong("landmark_id");
			landmarkIDs.add(landmarkID);
		}
		for (Long landmarkID : landmarkIDs) {
			String sql1 = "SELECT * FROM landmark WHERE landmark_id = ?";
			SqlRowSet row1 = jdbc.queryForRowSet(sql, landmarkID);
			while(row1.next()) {
				Landmark landmark = new Landmark();
				landmark.setId(row1.getLong("landmark_id"));
				landmark.setAddress(row1.getString("address"));
				landmark.setName(row1.getString("name"));
				landmark.setDescription(row1.getString("description"));
				landmark.setVenueType(row1.getString("venue_type"));
				output.add(landmark);
			}
		}
		return output;
	}

	@Override
	public Itinerary retrieveItinerary(int id) {
		String sql = "SELECT * FROM itinerary WHERE itinerary_id = ?";
		SqlRowSet result = jdbc.queryForRowSet(sql, id);
		Itinerary output = null;
		
		while(result.next()) {
			Long id2 = result.getLong("itinerary_id");
			String name = result.getString("name");
			String startingLocation = result.getString("starting_location");
			List<Landmark> destinations = retrieveItineraryLandmarks(id2);
			LocalDate date = result.getDate("date_of").toLocalDate();
			Long userId = result.getLong("user_id");
			
			output = new Itinerary(id2, name, startingLocation, destinations, date, userId);
		}
		return output;
	}

	@Override
	public void updateItinerary(Itinerary itinerary, int id) {
		String sql = "UPDATE itinerary SET name = ?, starting_location = ?, destinations = ?, date = ? WHERE itinerary_id = ?";
		String name = itinerary.getName();
		String startingLocation = itinerary.getStartingLocation();
		List<Landmark> destinations = itinerary.getDestinations();
		LocalDate date = itinerary.getDate();
		Long userId = itinerary.getUserId();
		
		jdbc.update(sql, name, startingLocation, destinations, date, id);
		
	}

	@Override
	public void deleteItinerary(int id) {
		String sql = "DELETE FROM itinerary WHERE itinerary_id = ?";
		
		jdbc.update(sql, id);
		
	}

	
}
