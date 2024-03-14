package com.alx.chitter.chitterBackend.controllers;

import com.alx.chitter.chitterBackend.model.PeepReply;
import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.requests.ReplyToPeepRequest;
import com.alx.chitter.chitterBackend.services.PeepsServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeepController {

    private final PeepsServices peepsServices;

    @Autowired
    public PeepController(PeepsServices peepsServices) {
        this.peepsServices = peepsServices;
    }


    @GetMapping("/")
    @CrossOrigin //https://docs.spring.io/spring-framework/reference/web/webmvc-cors.html
    public List<Peeps> getAllPeeps() {
        return peepsServices.getAllPeeps();
    }

    @PostMapping("/postPeeps")
    @CrossOrigin //CORS Needs to be per mapping?
    public Peeps postNewPeep(@Valid @RequestBody Peeps peeps){
        try {
            Peeps postNewPeep = peepsServices.postNewPeep(peeps);
            return postNewPeep;
        }catch (Exception e){
            e.printStackTrace();
            return new Peeps();
        }
    }

    @PostMapping("/reply")
    @CrossOrigin
    public Peeps replyToPeep(@Valid @RequestBody PeepReply peepReply){
        try{
            Peeps postPeepReply = peepsServices.replyToPeep(peepReply);
            return postPeepReply;
        } catch (Exception e){
            e.printStackTrace();
            return new Peeps();
        }
    }
}
