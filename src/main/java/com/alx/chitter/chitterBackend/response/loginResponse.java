package com.alx.chitter.chitterBackend.response;

import com.alx.chitter.chitterBackend.model.User;

import java.util.Optional;

public class loginResponse {
     int status;

    Message message;

    public loginResponse(int Status, User user) {
        this.status = Status;
        this.message = new Message(user);
    }
}

class Message{

    public String name;

    public String userName;

    public String pfpUrl;

   public Message(User user){
        this.name = user.getName();
        this.userName = user.getUserName();
        this.pfpUrl = " ";
    }

}