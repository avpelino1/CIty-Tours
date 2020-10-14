package com.techelevator.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.GeoLocateIn;

@Component
public class GoogleMaps {
	
	private JdbcTemplate jdbcTemplate;
	
	public List<String> geoLocate(List<String> placesToGeoLocate) throws JsonMappingException, JsonProcessingException {
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + "CA&key=AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(response.getBody());
		
		String latitude = jsonNode.path("results").path("geometry").path("location").path("lat").toString();
		String longitude =  jsonNode.path("results").path("geometry").path("location").path("lng").toString();
		
		System.out.println("LAT" + latitude);
		System.out.println("LONG" + longitude);
		
		return null;
	}

}
