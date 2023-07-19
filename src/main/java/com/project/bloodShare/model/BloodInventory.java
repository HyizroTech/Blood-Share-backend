package com.project.bloodShare.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Blood_Inventories")
public class BloodInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bloodInventoryId;

	@ManyToOne
	@JoinColumn(name = "bloodBankId", referencedColumnName = "bloodBankId")
	private BloodBank bloodBank;

	@Column(nullable = false)
	private String bloodType;

	@Column(nullable = false)
	private String bloodRhFactor;

	@Column(nullable = false)
	private int quantity;
}
