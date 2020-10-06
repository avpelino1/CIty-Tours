package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Landmark;

public interface LandmarkDAO {

	public List<Landmark> getAllLandmarks();
	
	
	
}
