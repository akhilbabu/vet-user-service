package com.vet.user_service.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegRequest {
    @NotBlank(message = "fullName must not be null")
    private String fullName;
    @NotBlank(message = "email must not be null")
    @Email(message = "emil must be valid")
    private String email;
    @NotBlank(message = "username must not be null")
    private String username;
    @NotBlank(message = "password must not be null")
    private String passwordHash;
    @NotBlank(message = "phone must not be null")
    private String phone;
    private List<String> pets;

}

