package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.Booking;

@Service
public interface BookingService {
	Booking addBooking(Booking booking);
	Booking deleteBooking(Booking booking);
	List<Booking> viewAllBooking();
	Booking viewBookingById(int id);
}
