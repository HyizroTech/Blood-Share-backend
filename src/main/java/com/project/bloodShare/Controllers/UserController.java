package com.project.bloodShare.Controllers;

import com.project.bloodShare.Exceptions.ResourceNotFoundException;
import com.project.bloodShare.Repostories.UserRepository;
import com.project.bloodShare.model.Patient;
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

    @PutMapping("/user/{id}")
    @PreAuthorize("hasAuthority('BloodBank') or hasAuthority('Donor')")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserId " + id + "not found"));
        user.setName(userRequest.getName());
        user.setPassword(encoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setCity(userRequest.getCity());
        user.setCountry(userRequest.getCountry());
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('BloodBank') or hasAuthority('Donor')")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {

        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();

        }).orElseThrow(() ->new ResourceNotFoundException("User id" + id + "not found"));
    }

}
