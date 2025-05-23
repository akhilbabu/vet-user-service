package com.vet.user_service.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Users")
@Getter
@Setter
public class Users {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String username;
    private String passwordHash;
    private String phone;
    private List<String> pets;
}
