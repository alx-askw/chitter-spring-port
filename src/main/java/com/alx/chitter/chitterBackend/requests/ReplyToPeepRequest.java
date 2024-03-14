package com.alx.chitter.chitterBackend.requests;

public class ReplyToPeepRequest {
    private String peepId;

    private String userName;

    private String name;

    private String peepContent;

    public String getPeepId() {
        return peepId;
    }

    public void setPeepId(String peepId) {
        this.peepId = peepId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeepContent() {
        return peepContent;
    }

    public void setPeepContent(String peepContent) {
        this.peepContent = peepContent;
    }
}
