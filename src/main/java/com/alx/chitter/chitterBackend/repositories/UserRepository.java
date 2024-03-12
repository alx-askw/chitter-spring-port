package com.alx.chitter.chitterBackend.repositories;

import com.alx.chitter.chitterBackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByUserName(String password);

    Optional<User> findByUserEmail(String userEmail);

}
