package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ItineraryDAO;
import com.techelevator.model.Itinerary;

@PreAuthorize("isAuthenticated()")
@CrossOrigin
@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
	
	@Autowired
	private ItineraryDAO itineraryDAO;
	
	@RequestMapping(path="/all", method=RequestMethod.GET)
	public List<Itinerary> retrieveAllItinerary() {
		return itineraryDAO.retrieveAllUserItinerary();
	}

	@RequestMapping(path="/shared", method=RequestMethod.GET)
	public List<Itinerary> retrieveSharedItineraries() {
		return itineraryDAO.retrieveSharedItineraries();
	}
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public void createItinerary(@RequestBody Itinerary itinerary) {
		itineraryDAO.createItinerary(itinerary);
	}
	
	@RequestMapping(path="/{id}/update", method=RequestMethod.PUT)
	public void updateItinerary(@RequestBody Itinerary newItinerary, @PathVariable Long id) {
		itineraryDAO.updateItinerary(newItinerary, id);
	}
	
	@RequestMapping(path="/{id}/delete", method=RequestMethod.DELETE)
	public void deleteItinerary(@PathVariable Long id) {
		itineraryDAO.deleteItinerary(id);
	}
	
}
