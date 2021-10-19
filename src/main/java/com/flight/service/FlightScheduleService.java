package com.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.entities.FlightSchedule;

@Service
public interface FlightScheduleService {
	FlightSchedule addFlightSchedule(FlightSchedule flightSchedule);
	FlightSchedule deleteFlightSchedule(FlightSchedule flightSchedule);
	FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule);
	List<FlightSchedule> viewAllFlightSchedule();
	FlightSchedule viewById(int id);
}
