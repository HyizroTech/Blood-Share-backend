//package com.project.bloodShare.model;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "Appointments")
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int appointmentId;
//
//    @Column(nullable = false)
//    private LocalDate date;
//
//    @Column(nullable = false)
//    private LocalTime time;
//
//    @ManyToOne
//    @JoinColumn(name = "donorId", referencedColumnName = "donorId")
//    private Donor donor;
//
//}
