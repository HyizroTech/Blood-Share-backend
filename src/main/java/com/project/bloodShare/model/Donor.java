package com.project.bloodShare.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "Donors")
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;

	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	@Column(nullable = false)
	private String bloodType;

	@Column(nullable = false)
	private String bloodRhFactor;

	@Column(nullable = true)
	private Date lastDonationDate;

}
