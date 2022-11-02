package com.bank.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.security.models.AuthRequest;
import com.bank.security.utils.JwtUtils;

@RestController
public class SecurityController {

	// authenticate and get jwt token

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/token/validate")
	public ResponseEntity<?> isTokenValid(@RequestHeader("Authorization") String jwtToken) {

		jwtToken = jwtToken.substring(7);

		String username = jwtUtils.extractUsername(jwtToken);

		UserDetails details = userDetailsService.loadUserByUsername(username);

		boolean isTokenValid = jwtUtils.validateToken(jwtToken, details);

		if (isTokenValid)
			return new ResponseEntity<>(true, HttpStatus.OK);
		else
			return new ResponseEntity<>(false, HttpStatus.OK);

	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {

		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(authRequest.getUsername());
		}

		String jwtToken = jwtUtils.generateToken(authRequest.getUsername());

		return new ResponseEntity<>(jwtToken, HttpStatus.OK);
	}

	@GetMapping("/admin")
	public String viewAdmin() {
		return "Hello admin";
	}

	@GetMapping("/user")
	public String viewUser() {
		return "Hello user";
	}

	@GetMapping("/all")
	public String viewAll() {
		return "Hello all";
	}
}
