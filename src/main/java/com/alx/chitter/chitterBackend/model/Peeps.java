package com.alx.chitter.chitterBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("peeps")
public class Peeps {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("userName")
    @NotEmpty(message="Need a username")
    private String userName;
    @JsonProperty("name")
    @NotEmpty(message="Need a name")
    private String name;

    @JsonProperty("peepDate")
    @NotEmpty(message = "Require Date")
    private LocalDateTime peepDate;

    @JsonProperty("peepContent")
    @NotEmpty(message = "Need content")
    private String peepContent;

    @JsonProperty("peepReplies")
    List<PeepReply> peepReplies;


    //! Constructor
    public Peeps(){
        this.peepDate = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
