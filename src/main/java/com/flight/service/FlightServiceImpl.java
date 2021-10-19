package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightRepository;
import com.flight.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight deleteFlight(Flight flight) {
		flightRepository.findById(flight.getFlightId()).orElseThrow(()-> new EntityNotFoundException("No such flight is avalable"));
		flightRepository.delete(flight);
		return null;
	}

	@Override
	public Flight updateFlight(Flight flight) {
		Flight f = flightRepository.findById(flight.getFlightId()).orElseThrow(()-> new EntityNotFoundException("No such flight is avalable"));
		return flightRepository.save(f);
	}

	@Override
	public List<Flight> viewAllFlight() {
		List<Flight> list = flightRepository.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("Empty");
		}else {
			return list;
		}
	}
	
}
