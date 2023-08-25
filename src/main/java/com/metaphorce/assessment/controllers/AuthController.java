package com.metaphorce.assessment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.assessment.models.AppUser;
import com.metaphorce.assessment.repository.IAppUserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAppUserRepository userRepository;

    AuthController(IAppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(AppUser user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testing")
    public ResponseEntity<?> testing() {
        return ResponseEntity.ok("something");
    }
}