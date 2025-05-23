package com.vet.user_service.model;

import org.springframework.http.HttpStatus;

public record RegistrationResponse(Boolean registrationStatus, String message, HttpStatus httpStatus) {
}
