package com.techelevator.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.GeoLocateIn;

public class GoogleMaps {
	
	public List<String> geoLocate(List<String> placesToGeoLocate) throws JsonMappingException, JsonProcessingException {
		
		System.out.println(placesToGeoLocate);
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=900%20W%20Riverside%20Dr%2C%20Austin%2C%20TX%2078704CA&key=AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonNode = objectMapper.readTree(response.getBody());
		
		System.out.println("google says: " + response.getBody().toString());
		System.out.println("google says: " + response.getStatusCode());
		
		String latitude = jsonNode.path("results").path("geometry").path("location").path("lat").toString();
		String longitude =  jsonNode.path("results").path("geometry").path("location").path("lng").toString();
		
		System.out.println("LAT" + latitude);
		System.out.println("LONG" + longitude);
		
		return null;
	}

}
