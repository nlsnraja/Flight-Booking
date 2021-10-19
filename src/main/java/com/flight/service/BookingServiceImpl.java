package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.BookingRepository;
import com.flight.entities.Booking;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking deleteBooking(Booking booking) {
		bookingRepository.findById(booking.getBookingId()).orElseThrow(()->new EntityNotFoundException("No such Booking available"));
		bookingRepository.delete(booking);
		return null;
	}

	@Override
	public List<Booking> viewAllBooking() {
		List<Booking> list = bookingRepository.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("No Bookings available");
		}
		return list;
	}

	@Override
	public Booking viewBookingById(int id) {
		Booking b = bookingRepository.findById((long) id).orElseThrow(()->new EntityNotFoundException("No such Booking available"));
		return b;
	}

}
