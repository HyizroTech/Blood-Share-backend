package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Repostories.BloodBankRepository;
import com.project.bloodShare.Repostories.DonorRepository;
import com.project.bloodShare.Repostories.UserRepository;
import com.project.bloodShare.model.BloodBank;
import com.project.bloodShare.model.Donor;
import com.project.bloodShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/test")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DonorRepository donorRepository;

    @Autowired
    BloodBankRepository bloodBankRepository;

    @GetMapping("/admin/bloodBanks")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<BloodBank>> getBloodBanks() {
        List<BloodBank> optionalBloodBank = bloodBankRepository.findAll();

        if (optionalBloodBank.isEmpty()) {
            throw new ResourceNotFoundException("No BloodBanks Found = ");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(optionalBloodBank));
        }
    }

    @GetMapping("/admin/donors")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<Donor>> getDonors() {
        List<Donor> optionalDonor = donorRepository.findAll();

        if (optionalDonor.isEmpty()) {
            throw new ResourceNotFoundException("No Donors Found = ");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(optionalDonor));
        }
    }

    @GetMapping("/admin/users")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<User>> getUsers() {
        List<User> optionalUser = userRepository.findAll();

        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No Donors Found = ");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(optionalUser));
        }
    }


}
