package com.alx.chitter.chitterBackend.helpers;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static List<Peeps> jsonFileToObject() {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            List<Peeps> peeps = objectMapper.readValue(JsonParser.class.getResourceAsStream("/testDate.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Peeps.class)
                    );
            System.out.println("flag" + peeps);
            return peeps;
        } catch (IOException e){
            return new ArrayList<>();
        }

    }
}
