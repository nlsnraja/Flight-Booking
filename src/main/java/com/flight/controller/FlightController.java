package com.flight.controller;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flight.entities.Flight;
import com.flight.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		Flight f = flightService.addFlight(flight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(f.getFlightId()).toUri();
		return ResponseEntity.created(location).body(f);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
		Flight f = flightService.updateFlight(flight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(f.getFlightId()).toUri();
		return ResponseEntity.created(location).body(f);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteFlight(@RequestBody Flight flight) {
		Flight f = flightService.deleteFlight(flight);
		if (f == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/view/all")
	public List<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}
}