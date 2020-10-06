package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Landmark;

@Component
public class JDBCLandmarkDAO implements LandmarkDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCLandmarkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Landmark> getAllLandmarks() {
		List<Landmark> allLandmarks = new ArrayList<>();
		String sql = "SELECT * FROM Landmark";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while (results.next()) {
			Landmark landmark = mapRowToLandmark(results);
			allLandmarks.add(landmark);
		}
		
		return allLandmarks;
	}
	
	public Landmark mapRowToLandmark(SqlRowSet results) {
		Landmark landmark = new Landmark();
		landmark.setId(results.getLong("landmark_id"));
		landmark.setAddress(results.getString("address"));
		landmark.setName(results.getString("name"));
		landmark.setDescription(results.getString("description"));
		landmark.setVenueType(results.getString("venue_type"));
		landmark.setImages(getImages((Object)results.getArray("images")));
		
		return landmark;
	}
	
//	public List<String> getImages(Object images) {
//		for (String string : images) {
//			
//		}
	}
}
