package com.projeto_estudo_spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto_estudo_spring.model.Produto;
import com.projeto_estudo_spring.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto>getProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
        //---------VERSAO SIMPLES---------------------
        //USANDO OPTIONAL

        // return service.buscarPorId(id)
        //     .map(ResponseEntity::ok) //se deu certo cria coleção pra responder ok
        //     .orElse(ResponseEntity.notFound().build()); // se nao   

        //-----VERSAO COM EXCEÇÃO
        // try {
        //     Produto produto = service.buscarPorId(id);
        //     return ResponseEntity.ok(produto);

        // } catch (RecursoNotFoundException e) {
        //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        // }

        //-----------VERSAO COM EXCEÇÃO COM GLOBALEXCEPTION
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
        //O PROPRIO SPRING VAI GERENCIAR A EXCEÇÃO PELA CLASSE CRIADA
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return service.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    
    }
}
