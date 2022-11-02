package com.bank.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.security.entity.UserEntity;
import com.bank.security.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserEntity> entities = userRepo.findByUsername(username);
		if (entities.size() == 0) {
			throw new UsernameNotFoundException("User not found");
		}
		// get user
		UserEntity userEntity = entities.get(0);

		// get authority for user
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(userEntity.getRoles()));

		// add user and its role to user class of spring security
		User user = new User(userEntity.getUsername(), userEntity.getPassword(), authority);

		return user;

	}

}
