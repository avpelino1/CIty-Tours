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
	

	

}
