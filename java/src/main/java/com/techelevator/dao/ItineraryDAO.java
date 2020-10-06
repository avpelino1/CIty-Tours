package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

public interface ItineraryDAO {

	public void createItinerary(Itinerary itinerary);
	
	public List<Itinerary> retrieveAllItinerary();
	
	public List<Landmark> retrieveItineraryLandmarks(Long itineraryID);
	
	public Itinerary retrieveItinerary(int id);
	
	public void updateItinerary(Itinerary itinerary, int id);
	
	public void deleteItinerary(int id);
	
}
