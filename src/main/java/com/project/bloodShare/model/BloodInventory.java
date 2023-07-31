package com.project.bloodShare.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BloodInventories")
public class BloodInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodInventoryId;

    @Column(nullable = false)
    private String bloodType;

    @Column(nullable = false)
    private String bloodRhFactor;

    @Column(nullable = false)
    private int quantity;
}
