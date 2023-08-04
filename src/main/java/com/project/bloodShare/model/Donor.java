package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

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
    @MapsId
    @JoinColumn(name = "donorId")
    private User user;

    @OneToMany(targetEntity = Appointment.class,fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "donor_id", referencedColumnName = "donorId")
    private Set<Appointment> appointments;
}
