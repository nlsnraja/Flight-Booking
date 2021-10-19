package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.Airline;

@Service
public interface AirlineService {
	Airline addAirline(Airline airline);
	Airline deleteAirline(Airline airline);
	Airline updateAirline(Airline airline);
	Airline viewAirline(int airlineId);
	List<Airline> viewAllAirlines();
}