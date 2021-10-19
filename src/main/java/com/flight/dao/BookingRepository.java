package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	Booking findBybookingId(int id);
}
