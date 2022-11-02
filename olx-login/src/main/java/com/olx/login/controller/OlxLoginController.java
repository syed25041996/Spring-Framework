package com.olx.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.login.entity.User;

@RestController
@RequestMapping("/user")
public class OlxLoginController {

	static int lastId = 0;

	// authenticates a user
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody User user, String authToken) {
		user.setId(++lastId);
		user.setUserName("syed");
		user.setPassword("syed1234");

		authToken = "12345";

		return new ResponseEntity<String>(authToken, HttpStatus.OK);

	}

	// user registration
	@PostMapping("/")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		user.setId(++lastId);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	//user logout
	@DeleteMapping("/logout")
	public ResponseEntity<?> logoutUser(@RequestHeader String authToken) {
		if (authToken.equals("12345")) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	// get the user
	//just the logic, data is not persisted, all values are null
	@GetMapping("/")
	public ResponseEntity<?> getUser(@RequestHeader String authToken){
		User user = new User();
		if (authToken.equals("12345")) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		
	}
}
