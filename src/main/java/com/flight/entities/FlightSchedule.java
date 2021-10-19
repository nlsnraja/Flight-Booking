package com.flight.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Airport departure;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Airport arrival;
	
	private double price;
	private double distance;
	private double duartion;
}
