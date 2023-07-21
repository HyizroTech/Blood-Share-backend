package com.project.bloodShare.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Blood_Banks")
public class BloodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBankId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
