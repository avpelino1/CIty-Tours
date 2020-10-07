package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.BusinessHours;
import com.techelevator.model.Images;
import com.techelevator.model.Landmark;

@Component
public class JDBCLandmarkDAO implements LandmarkDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCLandmarkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Landmark> getAllLandmarks() {
		List<Landmark> allLandmarks = new ArrayList<>();
		
		String sql = "SELECT * FROM landmark";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		String sqlImg = "SELECT * FROM Images WHERE landmark_id IS NOT NULL";
		SqlRowSet imgResults = jdbcTemplate.queryForRowSet(sqlImg);
		
		String sqlOperating= "SELECT * FROM buisness_hours";
		SqlRowSet operatingResults = jdbcTemplate.queryForRowSet(sqlOperating);
		
		while (results.next() || imgResults.next()) {
			Landmark landmark = mapRowToLandmark(results, imgResults, operatingResults);
			allLandmarks.add(landmark);
		}
		
		
		return allLandmarks;
	}
	
	public Landmark mapRowToLandmark(SqlRowSet results, SqlRowSet imgResults, SqlRowSet operatingResults) {
		Landmark landmark = new Landmark();
		landmark.setId(results.getLong("landmark_id"));
		landmark.setAddress(results.getString("address"));
		landmark.setName(results.getString("name"));
		landmark.setDescription(results.getString("description"));
		landmark.setVenueType(results.getString("venue_type"));
		landmark.setPendingApproval(results.getBoolean("pending_approval"));
		landmark.setImages(mapRowToImages(imgResults, results.getLong("landmark_id")));
		landmark.setBusinessHours(mapRowToHours(operatingResults, results.getLong("landmark_id")));
		
		return landmark;
	}
	
	public List<Images> mapRowToImages(SqlRowSet results, Long landmark_id) {
		List<Images> images = new ArrayList<>();
		Images image = new Images();
		
		while (results.next()) {
			if (results.getLong("landmark_id") == landmark_id) {
				image.setLandmarkId(results.getLong("landmark_id"));
				image.setImgUrl(results.getString("img_url"));
				images.add(image);
			}
		}
		return images;
	}
	
	public List<BusinessHours> mapRowToHours(SqlRowSet results, Long landmark_id) {
		List<BusinessHours> hoursOfOperation = new ArrayList<>();
		BusinessHours hours = new BusinessHours();
		
		while (results.next()) {
			if(results.getLong("landmark_id") == landmark_id) {
				hours.setDay(results.getLong("day_of"));
				hours.setOpen_time(results.getTime("open_time").toLocalTime());
				hours.setClose_time(results.getTime("close_time").toLocalTime());
			}
		}
		return hoursOfOperation;
	}
	
}
