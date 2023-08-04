package com.project.bloodShare.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Users",uniqueConstraints = {
		@UniqueConstraint(columnNames = "email")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String name;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 30)
	private String role;

	@NotBlank
	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(max = 30)
	private String phone;

	@NotBlank
	@Size(max = 120)
	private String city;

	@NotBlank
	@Size(max = 20)
	private String country;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
	private Donor donor;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
	private BloodBank bloodBank;
	public User(){

	}
	public User(String name, String password,String role,
				String email, String phone, String city, String country) {

		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.country = country;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}

