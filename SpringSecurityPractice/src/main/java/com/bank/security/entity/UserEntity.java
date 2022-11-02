package com.bank.security.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="users")
@Data
public class UserEntity {

	@Id
	int id;
	String username;
	String password;
	String roles;
}
