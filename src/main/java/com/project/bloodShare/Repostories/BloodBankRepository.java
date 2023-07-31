package com.project.bloodShare.Repostories;

import com.project.bloodShare.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank,Long> {
}