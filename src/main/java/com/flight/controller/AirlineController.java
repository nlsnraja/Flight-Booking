package com.flight.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flight.entities.Airline;
import com.flight.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
		Airline a = airlineService.addAirline(airline);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getAirlineId())
				.toUri();
		return ResponseEntity.created(location).body(a);
	}

	@PutMapping("/update")
	public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline) {
		Airline a = airlineService.updateAirline(airline);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getAirlineId())
				.toUri();
		return ResponseEntity.created(location).body(a);
	}

	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteAirline(@RequestBody Airline airline) {
		Airline a = airlineService.deleteAirline(airline);
		if (a == null) {
			return new ResponseEntity<String>("Airline Deleted Succesfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting..", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/all")
	public List<Airline> viewAllAirlines() {
		return airlineService.viewAllAirlines();
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Airline> viewAirlineById(@PathVariable int id) {
		Airline a = airlineService.viewAirline(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getAirlineId())
				.toUri();
		return ResponseEntity.created(location).body(a);
	}
	
	@GetMapping("/view/name{name}")
	public ResponseEntity<Airline> viewAirlineByName(@PathVariable String name) {
		Airline a = airlineService.viewAirlineByName(name);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getAirlineId())
				.toUri();
		return ResponseEntity.created(location).body(a);
	}
}
