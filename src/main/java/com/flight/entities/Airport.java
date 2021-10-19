package com.flight.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airportId;
	private String airportName;
	private String city;
	private String country;
}
