<<<<<<< HEAD
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
=======
//package com.project.bloodShare.model;
//
//import javax.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "Blood_Inventories")
//public class BloodInventory {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long bloodInventoryId;
//
//	@ManyToOne
//	@JoinColumn(name = "bloodBankId", referencedColumnName = "bloodBankId")
//	private BloodBank bloodBank;
//
//	@Column(nullable = false)
//	private String bloodType;
//
//	@Column(nullable = false)
//	private String bloodRhFactor;
//
//	@Column(nullable = false)
//	private int quantity;
//}
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
