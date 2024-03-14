package com.alx.chitter.chitterBackend.repositories;


import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PeepsRepository extends MongoRepository<Peeps, String> {
    Optional<Peeps> findById(String id);

}
