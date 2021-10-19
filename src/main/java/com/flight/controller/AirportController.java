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

import com.flight.entities.Airport;
import com.flight.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	private AirportService airportService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
		Airport a = airportService.addAirport(airport);
		URI locaion = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(a.getAirportId())
				.toUri();
		return ResponseEntity.created(locaion).body(a);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport){
		Airport a = airportService.updateAirport(airport);
		URI locaion = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(a.getAirportId())
				.toUri();
		return ResponseEntity.created(locaion).body(a);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteAirportEntity(@RequestBody Airport airport){
		Airport a = airportService.deleteAirport(airport);
		if(a==null) {
			return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Airport> viewAirportById(@PathVariable int id){
		Airport a = airportService.viewAirportById(id);
		URI locaion = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(a.getAirportId())
				.toUri();
		return ResponseEntity.created(locaion).body(a);
	}
	
	@GetMapping("/view/all")
	public List<Airport> viewAllAirport(){
		return airportService.viewAllAirport();
	}
}
