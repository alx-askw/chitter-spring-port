package com.alx.chitter.chitterBackend.controllers;

import com.alx.chitter.chitterBackend.model.User;
import com.alx.chitter.chitterBackend.requests.LoginRequest;
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
    public ResponseEntity<loginResponse> login(@RequestBody LoginRequest loginRequest){
        boolean validLogin = userServices.loginUser(loginRequest.getUserEmail(), loginRequest.getPassword());
        if(validLogin){
            Optional<User> currentUser = userServices.getUserByUserName(loginRequest.getUserEmail());
            loginResponse res = new loginResponse(200, currentUser);
            return ResponseEntity.ok(res);
        } else{
            loginResponse errorResponse = new loginResponse(404);
            return ResponseEntity.status(505).body(errorResponse);
        }
    }


}
