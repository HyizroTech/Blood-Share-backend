package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Blood_Banks")
public class BloodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBankId;

    @OneToOne
    @JoinColumn(name = "bloodBankId")
    private User user;
}
