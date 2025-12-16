package com.projeto_estudo_spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class helloRepository {

    public String mensagem(){
        return "Mensagem do repositorio";
    }
    
}
