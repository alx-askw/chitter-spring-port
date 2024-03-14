package com.alx.chitter.chitterBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PeepReply {


    @JsonProperty("peepId")
    @NotEmpty(message = "Parent Peep's Id is required!")
    private String peepId;

    @JsonProperty("userName")
    @NotEmpty(message = "Reply requires username")
    private String userName;

    @JsonProperty("name")
    @NotEmpty(message = "Reply requires name")
    private String name;

    @JsonProperty("peepDate")
    @NotNull
    private LocalDateTime peepDate;

    @JsonProperty("peepContent")
    @NotEmpty(message = "Reply requires content")
    private String peepContent;

    public PeepReply(){
        this.peepDate = LocalDateTime.now();
    }
    public PeepReply(@Valid PeepReply peepReply) {
        this.userName = peepReply.getUserName();
        this.name = peepReply.getName();
        this.peepContent = peepReply.getPeepContent();
        this.peepDate = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getPeepDate() {
        return peepDate;
    }

    public void setPeepDate(LocalDateTime peepDate) {
        this.peepDate = peepDate;
    }

    public String getPeepContent() {
        return peepContent;
    }

    public void setPeepContent(String peepContent) {
        this.peepContent = peepContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeepId() {
        return peepId;
    }

    public void setPeepId(String peepId) {
        this.peepId = peepId;
    }
}
