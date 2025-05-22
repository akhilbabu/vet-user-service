package com.vet.user_service.controller;


import com.vet.user_service.model.*;
import com.vet.user_service.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        // Replace with actual user validation logic
        if ("user123".equals(userRequest.getUsername()) && "pass123".equals(userRequest.getPassword())) {
            String token = JwtUtil.generateToken(userRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token, "Welcome " + userRequest.getUsername()));
        } else {
            return ResponseEntity.status(401).body(new AuthResponse(null, "Invalid credentials"));
        }
    }
}
