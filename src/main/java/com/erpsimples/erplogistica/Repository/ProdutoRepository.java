package com.erpsimples.erplogistica.Repository;

import com.erpsimples.erplogistica.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // métodos customizados, se houver
}