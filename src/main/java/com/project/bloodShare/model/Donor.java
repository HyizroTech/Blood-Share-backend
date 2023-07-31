package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225

@Data
@Entity
@Table(name = "Donors")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donorId;

<<<<<<< HEAD
    @Column(nullable = false)
    private String bloodType;

    @Column(nullable = true)
    private LocalDate lastDonationDate;

    @OneToOne
    @JoinColumn(name = "donorId")
    private User user;

    @OneToMany(targetEntity = Appointment.class,fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "donor_id", referencedColumnName = "donorId")
    private Set<Appointment> appointments;
=======
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
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
}
