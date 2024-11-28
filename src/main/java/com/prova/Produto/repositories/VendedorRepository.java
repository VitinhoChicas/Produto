package com.prova.Produto.repositories;

import com.prova.Produto.domains.Produto;
import com.prova.Produto.domains.Vendedor;
import org.hibernate.mapping.ValueVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {


    Optional<Vendedor> findByCpf(String cpf);
    Optional<Vendedor> findByRg(String rg);

}
