package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Payload.response.MessageResponse;
import com.project.bloodShare.Repostories.AppointmentRepository;
import com.project.bloodShare.Repostories.DonorRepository;
import com.project.bloodShare.model.Appointment;
import com.project.bloodShare.model.Donor;
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
public class AppointmentController {
    @Autowired
    DonorRepository donorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/donor/{id}/appointment")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<?> createAppointment(@PathVariable(value = "id") Long donorId,
                                                     @RequestBody Appointment appointmentRequest) {
        return donorRepository.findById(donorId).map(donor -> {
            donor.getAppointments().add(appointmentRequest);
            appointmentRepository.save(appointmentRequest);
            return ResponseEntity.ok(new MessageResponse("Appointment registered successfully!"));
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Donor with id = " + donorId));
    }


    @GetMapping("/donor/{id}/appointments")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<List<Appointment>> getDonorAppointments(@PathVariable(value = "id") Long donorId) {
        Optional<Donor> optionalDonor = donorRepository.findById(donorId);

        if (optionalDonor.isEmpty()) {
            throw new ResourceNotFoundException("Not found Donor with id = " + donorId);
        }

        Donor donor = optionalDonor.get();
        Set<Appointment> appointments = donor.getAppointments();

        if(appointments.isEmpty()){
            throw new ResourceNotFoundException("No Appointments Found");
        }

        else {
            return ResponseEntity.ok(new ArrayList<>(appointments));
        }
    }
    @PutMapping("/appointment/{id}")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointmentRequest) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AppointmentId " + id + "not found"));
            appointment.setDate(appointmentRequest.getDate());
            appointment.setTime(appointmentRequest.getTime());
        return new ResponseEntity<>(appointmentRepository.save(appointment), HttpStatus.OK);
    }

    @DeleteMapping("/appointment/{id}")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<Object> deleteAppointment(@PathVariable Long id) {

        return appointmentRepository.findById(id).map(appointment -> {
            appointmentRepository.delete(appointment);
            return ResponseEntity.ok().build();

        }).orElseThrow(() ->new ResourceNotFoundException("Appointment id" + id + "not found"));
    }

}
