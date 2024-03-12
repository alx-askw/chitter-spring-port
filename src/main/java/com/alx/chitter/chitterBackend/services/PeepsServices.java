package com.alx.chitter.chitterBackend.services;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.repositories.PeepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeepsServices {

    @Autowired
    private PeepsRepository peepsRepository;

    public List<Peeps> getAllPeeps(){
        return peepsRepository.findAll();
    }

}
