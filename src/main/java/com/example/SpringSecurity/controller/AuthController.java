package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.dto.AuthRequest;
import com.example.SpringSecurity.dto.AuthResponse;
import com.example.SpringSecurity.entity.AppUser;
import com.example.SpringSecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = authService.authenticate(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        return authService.registerUser(user);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Secured Hello!";
    }
}