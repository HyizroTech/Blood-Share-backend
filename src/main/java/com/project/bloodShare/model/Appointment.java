package com.project.bloodShare.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_APPOINTMENT_ID")
    private int id;

    @Column(name = "APP_DATE")
    private LocalDate date;

	@Column(name = "APP_TIME")
    private LocalTime time;
    
    @ManyToOne
    @JoinColumn(name = "DONOR_ID")
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private User createdBy;

}
