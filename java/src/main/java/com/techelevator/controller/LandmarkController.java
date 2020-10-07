package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.LandmarkDAO;
import com.techelevator.model.Landmark;

@RestController
public class LandmarkController {
	
	@Autowired
	LandmarkDAO landmarkDAO;
	
	@RequestMapping(path="/landmarks/all", method=RequestMethod.GET)
	public List<Landmark> allLandmarks() {
		List<Landmark> output = landmarkDAO.getAllLandmarks();
		return output;
	}
	
	@RequestMapping(path="/landmarks/:id", method=RequestMethod.GET)
	public void landmarkDetails() {}
	
	@RequestMapping(path="/landmarks/add", method=RequestMethod.POST)
	public void addLandmark() {}
	
	@PreAuthorize("ROLE_ADMIN")
	@RequestMapping(path="/landmarks/pending", method=RequestMethod.GET)
	public void pendingLandmarks() {}
	
	@RequestMapping(path="/landmarks/pending/:id/approve", method=RequestMethod.PUT)
	public void approvePendingLandmark() {}
	
	@RequestMapping(path="/landmarks/pending/:id/deny", method=RequestMethod.DELETE)
	public void denyPendingLandmark() {}
	
}
