package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flight.dao.UserRepository;
import com.flight.entities.Role;
import com.flight.entities.Users;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// LOAD USER BY NAME
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findByUserName(userName);
		if (user != null) {
			return new User(user.getUserName(), user.getPassword(), createSimpleGrantedAuthorities(user.getRoles()));
		} else {
			throw new UsernameNotFoundException("User with " + "user name " + userName + " not found");
		}

	}

	// ADDING ROLES IN TO LIST
	private static List<SimpleGrantedAuthority> createSimpleGrantedAuthorities(Set<Role> roles) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
				.collect(Collectors.toList());
		return authorities;
	}
}
