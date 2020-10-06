package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandmarkController {

	@RequestMapping(path="/landmarks/all", method=RequestMethod.GET)
	public void allLandmarks() {}
	
	@RequestMapping(path="/landmarks/:id", method=RequestMethod.GET)
	public void landmarkDetails() {}
	
	@RequestMapping(path="/landmarks/add", method=RequestMethod.POST)
	public void addLandmark() {}
	
	@RequestMapping(path="/landmarks/pending", method=RequestMethod.GET)
	public void pendingLandmarks() {}
	
	@RequestMapping(path="/landmarks/pending/:id/approve", method=RequestMethod.PUT)
	public void approvePendingLandmark() {}
	
	@RequestMapping(path="/landmarks/pending/:id/deny", method=RequestMethod.DELETE)
	public void denyPendingLandmark() {}
	
}
