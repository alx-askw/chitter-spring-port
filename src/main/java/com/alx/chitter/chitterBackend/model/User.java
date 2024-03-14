package com.alx.chitter.chitterBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("users")
public class User {


    @Id
    @JsonProperty("_id")
    private String _id;


    @JsonProperty("name")
    @NotEmpty(message = "Name required")
    private String name;

    @JsonProperty("userName")
    @NotEmpty(message = "username required")
    private String userName;

    @JsonProperty("userEmail")
    @NotEmpty(message = "userEmail required")
    private String userEmail;

    @JsonProperty("password")
    @NotEmpty(message = "password required")
    private String password;

    @JsonProperty("pfpUrl")
    private String pfpUrl;


    public User(String name, String userName, String userEmail, String password, String pfpUrl) {
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.pfpUrl = pfpUrl;
    }

    public User(){

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}