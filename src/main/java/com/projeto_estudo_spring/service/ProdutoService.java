package com.projeto_estudo_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_estudo_spring.model.Produto;
import com.projeto_estudo_spring.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }



}
