package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dao.UserRepository;
import com.flight.entities.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserRepository repository;
	
	// ADD NEW USER
		@Override
		public Users addNewUser(Users user) {
			return repository.save(user);
		}

		// USER SIGN IN
		@Override
		public Users signIn(Users user) {
			return null;
		}

		// USER SIGN OUT
		@Override
		public Users signOut(Users user) {
			return null;
		}

}
