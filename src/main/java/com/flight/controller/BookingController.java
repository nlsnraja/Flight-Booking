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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flight.entities.Booking;
import com.flight.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		Booking b = bookingService.addBooking(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}

	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteBooking(@RequestBody Booking booking) {
		Booking b = bookingService.deleteBooking(booking);
		if (b == null) {
			return new ResponseEntity<String>("Booking Deleted Succesfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting..", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view/all")
	public List<Booking> viewAllBooking() {
		return bookingService.viewAllBooking();
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable int id) {
		Booking b = bookingService.viewBookingById(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}
	
	@PostMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
		Booking b = bookingService.updateBooking(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}
}
