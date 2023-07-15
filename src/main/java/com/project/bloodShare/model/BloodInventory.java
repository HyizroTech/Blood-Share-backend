package com.project.bloodShare.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "BLOOD_INVENTORY")
public class BloodInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BIN_BLOOD_ID")
	private int id;

	@Column(name = "BIN_BLOOD_TYPE")
	private String bloodType;

	@Column(name = "BIN_QUANTITY")
	private int quantity;

	@Column(name = "BIN_EXPIRATION_DATE")
	private LocalDate expirationDate;

	@Column(name = "BIN_COLLECTION_DATE")
	private LocalDate collectionDate;

	@ManyToOne
	@JoinColumn(name = "DONOR_ID")
	private Donor donorId;

}
