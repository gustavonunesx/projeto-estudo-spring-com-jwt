package com.projeto_estudo_spring.repository;

import org.springframework.stereotype.Repository;
import com.projeto_estudo_spring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
