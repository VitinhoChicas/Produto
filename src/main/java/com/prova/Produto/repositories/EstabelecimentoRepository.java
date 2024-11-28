package com.prova.Produto.repositories;

import com.prova.Produto.domains.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {
 Optional<Estabelecimento> findByCnpj(String cnpj);
}
