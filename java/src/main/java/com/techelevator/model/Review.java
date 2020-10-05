package com.techelevator.model;

import java.util.List;

public class Review {

	private Long id;
	private String title;
	private String description;
	private List<String> images;
	private Long thumbsUp;
	private Long thumbsDown;
	private Long landmarkId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Long getThumbsUp() {
		return thumbsUp;
	}
	public void setThumbsUp(Long thumbsUp) {
		this.thumbsUp = thumbsUp;
	}
	public Long getThumbsDown() {
		return thumbsDown;
	}
	public void setThumbsDown(Long thumbsDown) {
		this.thumbsDown = thumbsDown;
	}
	public Long getLandmarkId() {
		return landmarkId;
	}
	public void setLandmarkId(Long landmarkId) {
		this.landmarkId = landmarkId;
	}
	
}
