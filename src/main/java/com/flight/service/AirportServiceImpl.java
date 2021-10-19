package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.AirportRepository;
import com.flight.entities.Airport;

@Service
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	AirportRepository airportRepository;
	
	@Override
	public Airport addAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Airport deleteAirport(Airport airport) {
		airportRepository.findById(airport.getAirportId()).orElseThrow(()->new EntityNotFoundException("No such airport is present"));
		airportRepository.delete(airport);
		return null;
	}

	@Override
	public Airport updateAirport(Airport airport) {
		Airport a = airportRepository.findById(airport.getAirportId()).orElseThrow(()->new EntityNotFoundException("No such airport is present"));
		a.setAirportName(airport.getAirportName());
		return airportRepository.save(a);
	}

	@Override
	public List<Airport> viewAllAirport() {
		List<Airport> list = airportRepository.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("Empty");
		}
		return list;
	}

	@Override
	public Airport viewAirportById(int id) {
		Airport a = airportRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No such airport is present"));
		return a;
	}

}
