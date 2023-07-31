package com.project.bloodShare.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

=======
import jakarta.persistence.*;
import lombok.Data;

>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
@Entity
@Data
@Table(name = "Blood_Banks")
public class BloodBank {
<<<<<<< HEAD
=======

>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBankId;

<<<<<<< HEAD
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

=======
    @OneToOne
    @JoinColumn(name = "bloodBankId")
    private User user;
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
}
