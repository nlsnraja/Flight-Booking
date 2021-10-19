package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.Airport;

@Service
public interface AirportService {
	Airport addAirport(Airport airport);
	Airport deleteAirport(Airport airport);
	Airport updateAirport(Airport airport);
	List<Airport> viewAllAirport();
	Airport viewAirportById(int id);
}
