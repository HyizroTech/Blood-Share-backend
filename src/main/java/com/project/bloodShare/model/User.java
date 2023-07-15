package com.project.bloodShare.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "USER_NAME")

	private String username;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_ROLE")
	private String role;

	@Column(name = "USER_FIRST_NAME")
	private String firstName;

	@Column(name = "USER_LAST_NAME")
	private String lastName;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PHONE")
	private String phone;

	@Column(name = "USER_ADDRESS")
	private String address;

	@Column(name = "USER_CREATED_AT")
	private LocalDate createdAt;

	@Column(name = "USER_UPDATED_AT")
	private LocalDate updatedAt;

}
