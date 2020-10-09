package com.techelevator.controller;

import java.io.IOException;
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
	public Boolean updateItinerary(@RequestBody Itinerary newItinerary, @PathVariable Long id, Principal principal) {
		try {
			itineraryDAO.updateItinerary(newItinerary, id, principal.getName());
			return true;
		} catch (IOException e) {
			return false;
			//front end if false; then tell them it's unauthorized
		}
		
	}
	
	@RequestMapping(path="/{id}/delete", method=RequestMethod.DELETE)
	public Boolean deleteItinerary(@PathVariable Long id, Principal principal) {
		try {
			itineraryDAO.deleteItinerary(id, principal.getName());
			return true;
		} catch (IOException e) {
			return false;
			//front end if false; then tell them it's unauthorized
		}
	}
	
	@RequestMapping(path="/{id}/share/{shareUsername}", method=RequestMethod.POST)
	public Boolean shareItinerary(@PathVariable Long id, @PathVariable String shareUsername, Principal principal) {
		try { 
			itineraryDAO.shareItinerary(id, shareUsername, principal.getName());
			return true;
		} catch (IOException e) {
			return false;
			//front end if false; then tell them it's unauthorized
		}
	}
	
	@RequestMapping(path="/{id}/removeShare/{shareUsername}", method=RequestMethod.DELETE)
	public Boolean removeShare(@PathVariable Long id, @PathVariable String shareUsername, Principal principal) {
		try {
			itineraryDAO.removeSharedItinerary(id, shareUsername, principal.getName());
			return true;
		} catch (IOException e) {
			return false;
			//front end if false; then tell them it's unauthorized
		}
	}
	
	@PreAuthorize("permitAll()")
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Itinerary sharePublicItinerary(@PathVariable Long id) {
		try {
			return itineraryDAO.getPublicItinerary(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			//if null then unauthorized
		}
	}
}
