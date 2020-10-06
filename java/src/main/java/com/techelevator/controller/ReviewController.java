package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
	
	@RequestMapping(value="/reviews/:id", method=RequestMethod.GET)
	public void landmarkReviews() {}
	
	@RequestMapping(value="/reviews/add", method=RequestMethod.POST)
	public void addLandmarkReview() {}

}
