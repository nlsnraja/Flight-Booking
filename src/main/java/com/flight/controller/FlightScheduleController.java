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

import com.flight.entities.FlightSchedule;
import com.flight.service.FlightScheduleService;

@RestController
@RequestMapping("/flightSchedule")
public class FlightScheduleController {

	@Autowired
	private FlightScheduleService flightScheduleService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<FlightSchedule> addFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
		FlightSchedule f = flightScheduleService.addFlightSchedule(flightSchedule);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(f.getId()).toUri();
		return ResponseEntity.created(location).body(f);
	}

	@PutMapping("/update")
	public ResponseEntity<FlightSchedule> updateFlightSChedule(@RequestBody FlightSchedule flightSchedule) {
		FlightSchedule f = flightScheduleService.updateFlightSchedule(flightSchedule);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(f.getId()).toUri();
		return ResponseEntity.created(location).body(f);
	}

	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
		FlightSchedule a = flightScheduleService.deleteFlightSchedule(flightSchedule);
		if (a == null) {
			return new ResponseEntity<String>("FlightSchedule Deleted Succesfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting..", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/all")
	public List<FlightSchedule> viewAllAirlines() {
		return flightScheduleService.viewAllFlightSchedule();
	}
}
