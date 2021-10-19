package com.flight.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.FlightScheduleRepository;
import com.flight.entities.FlightSchedule;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	private FlightScheduleRepository flightScheduleRepository;

	@Override
	public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule) {
		return flightScheduleRepository.save(flightSchedule);
	}

	@Override
	public FlightSchedule deleteFlightSchedule(FlightSchedule flightSchedule) {
		flightScheduleRepository.findById(flightSchedule.getId())
				.orElseThrow(() -> new EntityNotFoundException("No such Flight Schedule"));
		flightScheduleRepository.delete(flightSchedule);
		return null;
	}

	@Override
	public FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule) {
		FlightSchedule f = flightScheduleRepository.findById(flightSchedule.getId())
				.orElseThrow(() -> new EntityNotFoundException("No such Flight Schedule"));
		return flightScheduleRepository.save(flightSchedule);
	}

	@Override
	public List<FlightSchedule> viewAllFlightSchedule() {
		List<FlightSchedule> list = flightScheduleRepository.findAll();
		if(list.isEmpty()) {
			throw new NullPointerException("No Flight Schedule");
		}
		return list;
	}

}
