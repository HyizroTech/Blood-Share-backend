package com.project.bloodShare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Blood_Banks")
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBankId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "bloodBankId")
    private User user;

    @OneToMany(targetEntity = Patient.class,fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "bloodBank_Id", referencedColumnName = "bloodBankId")
    private Set<Patient> patients;

    @OneToMany(targetEntity = BloodInventory.class,fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "bloodBank_Id", referencedColumnName = "bloodBankId")
    private Set<BloodInventory> bloodInventories;

}
