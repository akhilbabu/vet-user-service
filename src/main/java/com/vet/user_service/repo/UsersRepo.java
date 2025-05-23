package com.vet.user_service.repo;

import com.vet.user_service.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends MongoRepository<Users, String> {
}
