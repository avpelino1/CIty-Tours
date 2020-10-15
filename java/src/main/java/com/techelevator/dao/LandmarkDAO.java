package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.techelevator.model.Landmark;

public interface LandmarkDAO {

	public List<Landmark> getAllLandmarks();
	
	public Landmark getLandmarkById(Long id);
	
	public void addLandmark(Landmark landmark) throws JsonMappingException, JsonProcessingException;

	public List<Landmark> getPendingLandmarks();
	
	public void approveLandmark(Long id);
	
	public void deleteLandmark(Long id);

}
