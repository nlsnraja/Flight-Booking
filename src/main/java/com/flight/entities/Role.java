package com.flight.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
	public static final String USER = "USER";
	public static final String ADMIN = "ADMIN";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private Roles roleName;
}