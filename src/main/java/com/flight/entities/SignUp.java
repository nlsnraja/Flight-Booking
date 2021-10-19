package com.flight.entities;


import lombok.Data;

@Data
public class SignUp {
	private String userName;
	private String password;
	private String[] roles;
}
