package com.techelevator.controller;

import java.security.Principal;
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
	public List<Itinerary> retrieveAllItinerary(Principal principal) {
		return itineraryDAO.retrieveAllUserItinerary(principal.getName());
	}

	@RequestMapping(path="/shared", method=RequestMethod.GET)
	public List<Itinerary> retrieveSharedItineraries(Principal principal) {
		return itineraryDAO.retrieveSharedItineraries(principal.getName());
	}
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public void createItinerary(@RequestBody Itinerary itinerary) {
		itineraryDAO.createItinerary(itinerary);
	}
	
	@RequestMapping(path="/{id}/update", method=RequestMethod.PUT)
	public void updateItinerary(@RequestBody Itinerary newItinerary, @PathVariable Long id, Principal principal) {
		itineraryDAO.updateItinerary(newItinerary, id, principal.getName());
	}
	
	@RequestMapping(path="/{id}/delete", method=RequestMethod.DELETE)
	public void deleteItinerary(@PathVariable Long id, Principal principal) {
		itineraryDAO.deleteItinerary(id, principal.getName());
	}
	
	@RequestMapping(path="/{id}/share/{shareUsername}", method=RequestMethod.POST)
	public void shareItinerary(@PathVariable Long id, @PathVariable String shareUsername, Principal principal) {
		itineraryDAO.shareItinerary(id, shareUsername, principal.getName());
	}
	
	@RequestMapping(path="/{id}/removeShare/{shareUsername}", method=RequestMethod.POST)
	public void removeShare(@PathVariable Long id, @PathVariable String shareUsername, Principal principal) {
		itineraryDAO.removeSharedItinerary(id, shareUsername, principal.getName());
	}
}
