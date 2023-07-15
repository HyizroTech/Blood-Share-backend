package com.project.bloodShare.model;

import javax.persistence.*;

@Entity
@Table(name = "Donors")
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONOR_ID")
	private int id;

	@Column(name = "DON_NAME")
	private String name;

	@Column(name = "DON_EMAIL")
	private String email;

	@Column(name = "DON_PHONE")
	private String phone;

	@Column(name = "DON_ADDRESS")
	private String address;

	@Column(name = "DON_BLOOD_TYPE")
	private String bloodType;

	@Column(name = "DON_DONATION_HISTORY")
	private String donationHistory;

	@Column(name = "DON_MEDICAL_HISTORY")
	private String medicalHistory;

}
