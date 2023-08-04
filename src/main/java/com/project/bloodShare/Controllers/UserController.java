package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Payload.response.MessageResponse;
import com.project.bloodShare.Repostories.UserRepository;
import com.project.bloodShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/test")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @PutMapping("/user/{id}/donor")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<?> updateUserDonor(@PathVariable("id") Long id, @RequestBody User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserId " + id + "not found"));
        if (user.getRole().equals("Donor")) {
            user.setName(userRequest.getName());
            user.setPassword(encoder.encode(userRequest.getPassword()));
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("User Updated successfully!"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/user/{id}/bloodBank")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<?> updateUserBloodBank(@PathVariable("id") Long id, @RequestBody User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserId " + id + "not found"));
        if (user.getRole().equals("BloodBank")) {
            user.setName(userRequest.getName());
            user.setPassword(encoder.encode(userRequest.getPassword()));
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("User Updated successfully!"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/user/{id}/donor")
    @PreAuthorize("hasAuthority('Donor')")
    public ResponseEntity<Object> deleteUserDonor(@PathVariable Long id) {

        return userRepository.findById(id).map(user -> {
            if(user.getRole().equals("Donor")) {
                userRepository.delete(user);
                return ResponseEntity.ok().build();

            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }).orElseThrow(() ->new ResourceNotFoundException("User id" + id + "not found"));

    }

    @DeleteMapping("/user/{id}/bloodBank")
    @PreAuthorize("hasAuthority('BloodBank')")
    public ResponseEntity<Object> deleteUserBloodBank(@PathVariable Long id) {

        return userRepository.findById(id).map(user -> {
            if (user.getRole().equals("BloodBank")) {
                userRepository.delete(user);
                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }

        }).orElseThrow(() ->new ResourceNotFoundException("User id" + id + "not found"));
    }

}
