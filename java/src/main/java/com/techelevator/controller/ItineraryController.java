package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ItineraryDAO;

@RestController
public class ItineraryController {
	
	@Autowired
	ItineraryDAO itineraryDAO;
	
	@RequestMapping(value="/itinerary/create", method=RequestMethod.POST)
	public void createItinerary() {}
	
	@RequestMapping(value="/itinerary/addLandmark", method=RequestMethod.PUT)
	public void addLandmark() {}
	
	@RequestMapping(value="/itinerary/removeLandmark", method=RequestMethod.PUT)
	public void removeLandmark() {}
	
	@RequestMapping(value="itinerary/updateStartingPoint", method=RequestMethod.PUT)
	public void updateStartingPoint() {}
	
	@RequestMapping(value="itinerary/delete", method=RequestMethod.DELETE)
	public void deleteItinerary() {}
	
	
	

}
