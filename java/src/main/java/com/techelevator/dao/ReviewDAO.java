package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Review;

public interface ReviewDAO {

	public List<Review> landmarkReviews(int landmarkID);
	
	public void addReview(Review review);
	
}
