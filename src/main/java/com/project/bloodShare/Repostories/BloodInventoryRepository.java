package com.project.bloodShare.Repostories;

import com.project.bloodShare.model.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodInventoryRepository extends JpaRepository<BloodInventory, Long> {
}
