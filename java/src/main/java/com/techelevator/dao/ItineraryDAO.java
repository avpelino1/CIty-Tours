package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

public interface ItineraryDAO {

	public void createItinerary(Itinerary itinerary);
	
	public List<Itinerary> retrieveAllUserItinerary();
	
	public List<Itinerary> retrieveSharedItineraries();
	
	public List<Landmark> retrieveItineraryLandmarks(Long itineraryID);
	
	public Itinerary retrieveItinerary(int id);
	
	public void updateItinerary(Itinerary itinerary, int id);
	
	public void deleteItinerary(int id);
	
}
