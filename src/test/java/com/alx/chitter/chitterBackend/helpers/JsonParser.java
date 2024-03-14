package com.alx.chitter.chitterBackend.helpers;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//! IMPORTANT###############################################
// Firstly - On error print the stack trace to save hours
// Secondly - my json data contains a data format which java doesn't like - use jackson jsr310 and registerModule to get it working
// https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
//##############################################################

public class JsonParser {
    public static List<Peeps> jsonFileToObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try{
            List<Peeps> peeps = objectMapper.readValue(JsonParser.class.getResourceAsStream("/testDate.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Peeps.class)
                    );
            System.out.println("flag" + peeps);

            return peeps;
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public static List<User> userJsonFileToObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            List<User> users = objectMapper.readValue(JsonParser.class.getResourceAsStream("/userTestData.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, User.class)
            );

            return users;
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
