package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flight.dao.AirlineRepository;
import com.flight.entities.Airline;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	@Override
	public Airline addAirline(Airline airline) {
		return airlineRepository.save(airline);
	}

	@Override
	public Airline deleteAirline(Airline airline) {
		airlineRepository.findById(airline.getAirlineId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No airline is available with this id"));
		airlineRepository.delete(airline);
		return null;
	}

	@Override
	public Airline updateAirline(Airline airline) {
		Airline a =airlineRepository.findById(airline.getAirlineId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No airline is available with this id"));
		a.setAirlineName(airline.getAirlineName());
		a.setImageUrl(airline.getImageUrl());
		return airlineRepository.save(a);
	}

	@Override
	public Airline viewAirline(int airlineId) {
		Airline a =airlineRepository.findById((long) airlineId)
				.orElseThrow(() -> new EntityNotFoundException("Currently No airline is available with this id"));
		return a;
	}

	@Override
	public List<Airline> viewAllAirlines() {
		List<Airline> list = airlineRepository.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("Currently no airlines are available");
		}
		return list;
	}

}
