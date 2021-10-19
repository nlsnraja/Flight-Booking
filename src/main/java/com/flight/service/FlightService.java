package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.Flight;

@Service
public interface FlightService {
	Flight addFlight(Flight flight);
	Flight deleteFlight(Flight flight);
	Flight updateFlight(Flight flight);
	List<Flight> viewAllFlight();
}
