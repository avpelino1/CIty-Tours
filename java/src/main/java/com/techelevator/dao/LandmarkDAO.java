package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Landmark;

public interface LandmarkDAO {

	public List<Landmark> getAllLandmarks();
	
	public Landmark getLandmarkById(Long id);
	
	public void addLandmark(Landmark landmark);

	public List<Landmark> getPendingLandmarks();
	
	public void approveLandmark(Long id);
	
	public void deleteLandmark(Long id);

}
