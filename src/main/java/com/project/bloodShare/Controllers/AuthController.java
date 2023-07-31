package com.project.bloodShare.Controllers;

import com.project.bloodShare.Payload.request.BloodBankSignupRequest;
import com.project.bloodShare.Payload.request.LoginRequest;
import com.project.bloodShare.Payload.request.DonorSignupRequest;
import com.project.bloodShare.Payload.response.JwtResponse;
import com.project.bloodShare.Payload.response.MessageResponse;
import com.project.bloodShare.Repostories.DonorRepository;
import com.project.bloodShare.Repostories.UserRepository;
import com.project.bloodShare.SecurityConfig.jwt.JwtUtils;
import com.project.bloodShare.SecurityConfig.services.UserDetailsImpl;
import com.project.bloodShare.model.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    DonorRepository donorRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getRole()

        ));
    }

    @PostMapping("/register/donor")
    public ResponseEntity<?> registerDonor(@Valid @RequestBody DonorSignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getName(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.setRole("Donor"),
                signUpRequest.getEmail(),
                signUpRequest.getPhone(),
                signUpRequest.getCity(),
                signUpRequest.getCountry()
                );

        Donor donor = new Donor();
        donor.setBloodType(signUpRequest.getBloodType());
        donor.setLastDonationDate(signUpRequest.getLastDonationDate());
        user.setDonor(donor);
        donor.setUser(user);

        userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/register/BloodBank")
    public ResponseEntity<?> registerBloodBank(@Valid @RequestBody BloodBankSignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getName(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.setRole("BloodBank"),
                signUpRequest.getEmail(),
                signUpRequest.getPhone(),
                signUpRequest.getCity(),
                signUpRequest.getCountry()
        );

        BloodBank bloodBank = new BloodBank();
        user.setBloodBank(bloodBank);
        bloodBank.setUser(user);

        userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));



    }



}