package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Payload.response.MessageResponse;
import com.project.bloodShare.Repostories.BloodBankRepository;
import com.project.bloodShare.Repostories.PatientRepository;
import com.project.bloodShare.model.BloodBank;
import com.project.bloodShare.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/test")
public class PatientController {
    @Autowired
    BloodBankRepository bloodBankRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("bloodBank/{id}/patient")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<?> createBloodBankPatients(@PathVariable(value = "id") Long bloodBankId,
                                                           @RequestBody Patient patientRequest) {
        return bloodBankRepository.findById(bloodBankId).map(bloodBank -> {
            bloodBank.getPatients().add(patientRequest);
            patientRepository.save(patientRequest);
            return ResponseEntity.ok(new MessageResponse("Patient registered successfully!"));
        }).orElseThrow(() -> new ResourceNotFoundException("Not found BloodBank with id = " + bloodBankId));
    }
    @GetMapping("bloodBank/{id}/patients")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<List<Patient>> getBloodBankPatients(@PathVariable(value = "id") Long bloodBankid) {
        Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(bloodBankid);

        if (optionalBloodBank.isEmpty()) {
            throw new ResourceNotFoundException("Not found BloodBank with id = " + bloodBankid);
        }

        BloodBank bloodBank = optionalBloodBank.get();
        Set<Patient> patients = bloodBank.getPatients();

        if(patients.isEmpty()){
            throw new ResourceNotFoundException("No Patients Found");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(patients));
        }
    }
    @PutMapping("/patient/{id}")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patientRequest) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PatientId " + id + "not found"));
        patient.setName(patientRequest.getName());
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());
        patient.setBloodType(patientRequest.getBloodType());
        patient.setBloodRhFactor(patientRequest.getBloodRhFactor());
        return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id}")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) {

        return patientRepository.findById(id).map(patient -> {
            patientRepository.delete(patient);
            return ResponseEntity.ok().build();

        }).orElseThrow(() ->new ResourceNotFoundException("Patient id" + id + "not found"));
    }

}
