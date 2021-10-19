package com.flight.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dao.RoleRepository;
import com.flight.dao.UserRepository;
import com.flight.entities.Role;
import com.flight.entities.Roles;
import com.flight.entities.SignUp;
import com.flight.entities.Users;
import com.flight.service.UsersServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UsersServiceImpl userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;

	// ADD NEW USER
//	@PostMapping("/user")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Users> addNewUser(@Valid @RequestBody Users user) {
//		Users user1 = userService.addNewUser(user);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getUserId())
//				.toUri();
//		return ResponseEntity.created(location).body(user1);
//	}

	// SIGN IN
	public Users signIn(Users user) {
		return userService.signIn(user);
	}

	// SIGN OUT
	public Users signOut(Users user) {
		return userService.signOut(user);
	}

	// SIGN UP
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody SignUp signupRequest) {
		if (userRepository.existsByUserName(signupRequest.getUserName())) {
			return ResponseEntity.badRequest().body("Username is already taken");
		}

		Users user = new Users(0, null);
		Set<Role> roles = new HashSet<>();
		user.setUserName(signupRequest.getUserName());
		user.setPassword(encoder.encode(signupRequest.getPassword()));
		System.out.println("Encoded password--- " + user.getPassword());
		String[] roleArr = signupRequest.getRoles();

		if (roleArr == null) {
			roles.add(roleRepository.findByRoleName(Roles.ROLE_USER).get());
		}
		for (String role : roleArr) {
			switch (role) {
			case "admin":
				roles.add(roleRepository.findByRoleName(Roles.ROLE_ADMIN).get());
				break;
			case "user":
				roles.add(roleRepository.findByRoleName(Roles.ROLE_USER).get());
				break;
			default:
				return ResponseEntity.badRequest().body("Specified role not found");
			}
		}
		user.setRoles(roles);
		userService.addNewUser(user);
		return ResponseEntity.ok("User signed up successfully");
	}
}
