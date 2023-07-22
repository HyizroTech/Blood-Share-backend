package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donorId;

    @Column(nullable = false)
    private String bloodType;

    @Column(nullable = true)
    private LocalDate lastDonationDate;

    @OneToOne
    @JoinColumn(name = "donorId")
    private User user;
}
