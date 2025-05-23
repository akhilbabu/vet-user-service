package com.vet.user_service.controller;


import com.vet.user_service.model.*;
import com.vet.user_service.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLoginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UseLoginRequest useLoginRequest) {
        // Replace with actual user validation logic
        if ("user123".equals(useLoginRequest.getUsername()) && "pass123".equals(useLoginRequest.getPassword())) {
            String token = JwtUtil.generateToken(useLoginRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token, "Welcome " + useLoginRequest.getUsername()));
        } else {
            return ResponseEntity.status(401).body(new AuthResponse(null, "Invalid credentials"));
        }
    }
}
