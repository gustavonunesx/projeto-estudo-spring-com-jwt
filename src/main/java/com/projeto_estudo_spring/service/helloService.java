package com.projeto_estudo_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_estudo_spring.repository.helloRepository;

@Service
public class helloService {
    
    @Autowired
    private helloRepository repository;

    public String sendMsgToController(){
        return repository.mensagem();
    }
}
