package com.project.bloodShare.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/test")
public class TestController {
    @GetMapping("/donor")
    @PreAuthorize("hasAuthority('Donor')")
    public String userAccess() {
        return "User Content.";
    }
    @GetMapping("/bloodBank")
    @PreAuthorize("hasAuthority('BloodBank')")
    public String adminAccess() {
        return "BloodBank Board.";
    }
}
