package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUserName(String userName);
	boolean existsByUserName(String userName);
}
