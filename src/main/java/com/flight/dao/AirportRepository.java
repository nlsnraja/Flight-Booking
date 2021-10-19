package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entities.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer>{
	Airport findByairportName(String name);
}
