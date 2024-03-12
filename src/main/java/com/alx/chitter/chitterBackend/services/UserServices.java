package com.alx.chitter.chitterBackend.services;

import com.alx.chitter.chitterBackend.model.User;
import com.alx.chitter.chitterBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    @Autowired //autowired gets the repo and assigns it to the variable
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean loginUser(String userEmail, String userPassword) {
        Optional<User> userOptional = userRepository.findByUserEmail(userEmail);
        if(userOptional.isPresent()){
           User user = userOptional.get();
           return user.getPassword().equals(userPassword);
        }
        return false;
    }

    public Optional<User> getUserByUserName(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }


}
