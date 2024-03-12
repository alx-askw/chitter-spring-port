package com.alx.chitter.chitterBackend.controllers;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.services.PeepsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeepController {

    private final PeepsServices peepsServices;

    @Autowired
    public PeepController(PeepsServices peepsServices) {
        this.peepsServices = peepsServices;
    }

    @CrossOrigin //https://docs.spring.io/spring-framework/reference/web/webmvc-cors.html

    @GetMapping("/")
    public List<Peeps> getAllPeeps() {
        return peepsServices.getAllPeeps();
    }

}
