<<<<<<< HEAD
package com.project.bloodShare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String bloodType;

    @Column(nullable = false)
    private String bloodRhFactor;


}
=======
//package com.project.bloodShare.model;
//
//import javax.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "Patients")
//public class Patient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "patient_id")
//    private Long patientId;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private int age;
//
//    @Column(nullable = false)
//    private String gender;
//
//    @Column(nullable = false)
//    private String bloodType;
//
//    @Column(nullable = false)
//    private String bloodRhFactor;
//
//    @ManyToOne
//    @JoinColumn(name = "bloodBankId", referencedColumnName = "bloodBankId")
//    private BloodBank bloodBank;
//}
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
