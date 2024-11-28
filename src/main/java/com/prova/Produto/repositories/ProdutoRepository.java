package com.prova.Produto.repositories;

import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByDescricao(String descricao);
}
