package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Repostories.DonorRepository;
import com.project.bloodShare.Repostories.UserRepository;
import com.project.bloodShare.model.Donor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DonorRepository donorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Optional<Donor> optionalDonor = donorRepository.findById(id);

        if (optionalDonor.isPresent()) {
            return ResponseEntity.ok(optionalDonor.get());
        } else {
            throw new ResourceNotFoundException("Donor with ID " + id + " not found");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<Donor> updateDonor(@PathVariable("id") Long id, @RequestBody Donor donorRequest) {
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DonorId " + id + "not found"));
        donor.setBloodType(donorRequest.getBloodType());
        donor.setLastDonationDate(donorRequest.getLastDonationDate());
        return new ResponseEntity<>(donorRepository.save(donor), HttpStatus.OK);
    }
}
