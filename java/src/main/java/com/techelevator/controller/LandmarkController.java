package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandmarkController {

	@RequestMapping(value="/landmarks/all", method=RequestMethod.GET)
	public void allLandmarks() {}
	
	@RequestMapping(value="/landmarks/:id", method=RequestMethod.GET)
	public void landmarkDetails() {}
	
	@RequestMapping(value="/landmarks/add", method=RequestMethod.POST)
	public void addLandmark() {}
	
	@RequestMapping(value="/landmarks/pending", method=RequestMethod.GET)
	public void pendingLandmarks() {}
	
	@RequestMapping(value="/landmarks/pending/:id/approve", method=RequestMethod.PUT)
	public void approvePendingLandmark() {}
	
	@RequestMapping(value="/landmarks/pending/:id/deny", method=RequestMethod.DELETE)
	public void denyPendingLandmark() {}
	
}
