package com.alx.chitter.chitterBackend.response;

import com.alx.chitter.chitterBackend.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

//! IMPORTANT ###################################################
// FOR JACKSON JSON SERIAL TO WORK IT NEEDS GETTERS AND SETTERS - MUCH TIME WASTED
// #######################################################################

@JsonInclude(JsonInclude.Include.NON_NULL)
public class loginResponse {
     private int status;

    private String name;

    private String userName;

    public loginResponse(int Status, Optional<User> user) {
        this.status = Status;
        if(user.isPresent()) {
            this.name = user.get().getName();
            this.userName = user.get().getUserName();
        } else{
            this.name = null;
            this.userName = null;
        }
    }

    public loginResponse(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
