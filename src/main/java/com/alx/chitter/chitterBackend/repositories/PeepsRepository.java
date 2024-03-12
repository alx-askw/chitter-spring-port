package com.alx.chitter.chitterBackend.repositories;


import com.alx.chitter.chitterBackend.model.Peeps;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PeepsRepository extends MongoRepository<Peeps, String> {

}
