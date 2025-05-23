package com.vet.user_service.controller;


import com.vet.user_service.model.AuthResponse;
import com.vet.user_service.model.RegistrationResponse;
import com.vet.user_service.model.UseLoginRequest;
import com.vet.user_service.model.UserRegRequest;
import com.vet.user_service.service.UserRegistrationService;
import com.vet.user_service.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping("/registration")
    public ResponseEntity<?> login(@Valid @RequestBody  UserRegRequest userRegRequest) {
        RegistrationResponse registrationResponse = userRegistrationService.process(userRegRequest);
        return new ResponseEntity<>(registrationResponse,registrationResponse.httpStatus());
    }

}
