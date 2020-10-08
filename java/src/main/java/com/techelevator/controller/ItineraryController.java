package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.model.Itinerary;

@CrossOrigin
@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
	
	@Autowired
	ItineraryDAO itineraryDAO;
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Itinerary> retrieveAllItinerary() {
		return itineraryDAO.retrieveAllUserItinerary();
	}
	
	

	@RequestMapping(path="/create", method=RequestMethod.POST)
	public void createItinerary(@RequestBody Itinerary itinerary) {
		itineraryDAO.createItinerary(itinerary);
	}
	
	@RequestMapping(path="/{id}/update", method=RequestMethod.PUT)
	public void updateItinerary(@RequestBody Itinerary newItinerary, @PathVariable int id) {
		itineraryDAO.updateItinerary(newItinerary, id);
	}
	
	@RequestMapping(path="/{id}/delete", method=RequestMethod.DELETE)
	public void deleteItinerary(@PathVariable int id) {
		itineraryDAO.deleteItinerary(id);
	}
	

}
