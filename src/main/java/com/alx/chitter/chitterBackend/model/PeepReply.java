package com.alx.chitter.chitterBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class PeepReply {
    @JsonProperty("userName")
    @NotEmpty(message = "Reply requires username")
    private String userName;

    @JsonProperty("peepDate")
    @NotEmpty(message = "Reply date required")
    private LocalDateTime peepDate;

    @JsonProperty("peepContent")
    @NotEmpty(message = "Reply requires content")
    private String peepContent;

}
