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

    private Message message;

    public loginResponse(int Status, Optional<User> user) {
        this.status = Status;
        if(user.isPresent()) {
            this.message = new Message(user.get());
        } else{
            this.message = null;
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

class Message{

    private String name;

    private String userName;

    private String pfpUrl;

   public Message(User user){
        this.name = user.getName();
        this.userName = user.getUserName();
        this.pfpUrl = " ";
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

    public String getPfpUrl() {
        return pfpUrl;
    }

    public void setPfpUrl(String pfpUrl) {
        this.pfpUrl = pfpUrl;
    }
}