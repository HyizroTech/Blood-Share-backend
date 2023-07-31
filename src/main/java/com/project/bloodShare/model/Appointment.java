<<<<<<< HEAD
package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

}
=======
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
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
