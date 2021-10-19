package com.flight.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discountId;
	private String discountCoupon;
	
	@Enumerated(EnumType.STRING)
	private MealType mealType;
}
