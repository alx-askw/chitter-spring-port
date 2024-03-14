package com.alx.chitter.chitterBackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//NOTE ####################################################
// Don't use the not empty annotation on non strings - use NotNull perhaps
//https://stackoverflow.com/questions/52608600/hv000030-no-validator-could-be-found-for-constraint-javax-validation-constrai
//https://stackoverflow.com/questions/24053139/spring-mvc-form-validation-date-field
//##########################################################################


@Document("peeps")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
//    @NotEmpty(message = "Require Date")
    @NotNull
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
        this.peepReplies = new ArrayList<PeepReply>(); // Frontend is expecting a reply array regardless of number of arrays
    }
}
