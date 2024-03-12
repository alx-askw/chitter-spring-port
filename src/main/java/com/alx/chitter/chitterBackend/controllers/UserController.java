package com.alx.chitter.chitterBackend.controllers;

import com.alx.chitter.chitterBackend.model.User;
import com.alx.chitter.chitterBackend.response.loginResponse;
import com.alx.chitter.chitterBackend.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    };

    @GetMapping(value = "/getusers")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @CrossOrigin
    //generic to return something based on some logic
    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody User user){
        boolean validLogin = userServices.loginUser(user.getUserEmail(), user.getPassword());
        if(validLogin){
            Optional<User> currentUser = userServices.getUserByUserName(user.getUserEmail());
            return ResponseEntity.ok(200 );
        }
        return ResponseEntity.ok(404);
    }

}
