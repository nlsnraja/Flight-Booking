package com.flight.service;

import org.springframework.stereotype.Service;

import com.flight.entities.Users;

@Service
public interface UsersService {
	public abstract Users addNewUser(Users user);
	public abstract Users signIn(Users user);
	public abstract Users signOut(Users user);
}
