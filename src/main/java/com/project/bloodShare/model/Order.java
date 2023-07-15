package com.project.bloodShare.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORD_ORDER_ID")
	private int id;

	@Column(name = "ORD_RECIPIENT_NAME")
	private String recipientName;

	@Column(name = "ORD_BLOOD_TYPE")
	private String bloodType;

	@Column(name = "ORD_QUANTITY")
	private int quantity;

	@Column(name = "ORD_ORDER_DATE")
	private LocalDate orderDate;

	@ManyToOne
	@JoinColumn(name = "BLOOD_ID")
	private BloodInventory bloodId;

	@ManyToOne
	@JoinColumn(name = "CREATED_BY")
	private User createdBy;

}
