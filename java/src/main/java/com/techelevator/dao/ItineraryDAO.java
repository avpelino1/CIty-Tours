package com.techelevator.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

public interface ItineraryDAO {

	public void createItinerary(Itinerary itinerary);
	
	public List<Itinerary> retrieveAllUserItinerary(String username);
	
	public List<Itinerary> retrieveSharedItineraries(String username);
	
	public List<Landmark> retrieveItineraryLandmarks(Long itineraryID);
	
	public Itinerary retrieveItinerary(Long id);
	
	public void updateItinerary(Itinerary itinerary, Long id, String username) throws IOException;
	
	public void deleteItinerary(Long id, String username) throws IOException;
	
	public void shareItinerary(Long itineraryId, String shareUsername, String username) throws IOException;
	
	public void removeSharedItinerary(Long itineraryId, String shareUsername, String username) throws IOException;
}
