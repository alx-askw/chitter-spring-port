package com.alx.chitter.chitterBackend.services;

import com.alx.chitter.chitterBackend.model.PeepReply;
import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.repositories.PeepsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeepsServices {

    @Autowired
    private PeepsRepository peepsRepository;

    public List<Peeps> getAllPeeps(){
        return peepsRepository.findAll();
    }

    public Peeps postNewPeep(Peeps postNewPeepRequest) {
        return peepsRepository.save(postNewPeepRequest);
    }

    public Peeps replyToPeep(@Valid PeepReply peepReply) {
        Optional<Peeps> getPeepToReplyTo = peepsRepository.findById(peepReply.getPeepId());
        if(getPeepToReplyTo.isPresent()){
            Peeps peeps = getPeepToReplyTo.get(); //get peep object out of optional
            PeepReply replyToAdd = new PeepReply(peepReply);
            peeps.getPeepReplies().add(replyToAdd);
            return peepsRepository.save(peeps); //remember to save
        }
        return new Peeps();
    }
}
