package com.vet.user_service.service;

import com.vet.user_service.entity.Users;
import com.vet.user_service.model.RegistrationResponse;
import com.vet.user_service.model.UserRegRequest;
import com.vet.user_service.repo.UsersRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class UserRegistrationService {

    @Autowired
    private UsersRepo usersRepo;

    public RegistrationResponse process(UserRegRequest userRegRequest) {
        if (Objects.nonNull(userRegRequest)) {
            try {
              //  List<Users> all = usersRepo.findAll();
                Users users = new Users();
                users.setEmail(userRegRequest.getEmail());
                users.setUsername(userRegRequest.getUsername());
                users.setPhone(userRegRequest.getPhone());
                users.setFullName(userRegRequest.getFullName());
                Users saved = usersRepo.save(users);
                return new RegistrationResponse(true, "user created with user id: "+saved.getId(),HttpStatus.OK);

            } catch (Exception e) {
                log.error("Error while updating Users ", e);
                return new RegistrationResponse(false, "Error while updating Users ", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new RegistrationResponse(false, "request not valid",HttpStatus.BAD_REQUEST);


    }

}
