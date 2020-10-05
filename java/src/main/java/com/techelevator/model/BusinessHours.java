package com.techelevator.model;

import java.time.LocalTime;

public class BusinessHours {

	private Long landmarkId;
	private Long day;
	private LocalTime open_time;
	private LocalTime close_time;
	
	public Long getLandmarkId() {
		return landmarkId;
	}
	public void setLandmarkId(Long landmarkId) {
		this.landmarkId = landmarkId;
	}
	public Long getDay() {
		return day;
	}
	public void setDay(Long day) {
		this.day = day;
	}
	public LocalTime getOpen_time() {
		return open_time;
	}
	public void setOpen_time(LocalTime open_time) {
		this.open_time = open_time;
	}
	public LocalTime getClose_time() {
		return close_time;
	}
	public void setClose_time(LocalTime close_time) {
		this.close_time = close_time;
	}
	
	
	
}
