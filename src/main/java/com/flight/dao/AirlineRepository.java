package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entities.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
	Airline findByairlineId(int id);
}
