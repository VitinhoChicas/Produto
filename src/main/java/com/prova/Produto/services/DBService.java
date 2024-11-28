package com.prova.Produto.services;

import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.Produto;
import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.enums.Avaliacao;
import com.prova.Produto.domains.enums.Status;
import com.prova.Produto.repositories.EstabelecimentoRepository;
import com.prova.Produto.repositories.ProdutoRepository;
import com.prova.Produto.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDate;
@Service
public class DBService {


    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void initDB(){
        Vendedor vendedor01 = new Vendedor(null, "Autor01", "11111111111", "1111", "15650000", "Junior", "5000");
        Estabelecimento estabelecimento01 = new Estabelecimento(null, "111", "Estabelecimento01", "Rua São Sebastião N99","São Paulo");
        Produto produto01 = new Produto(null,  "descicao01", 5,  new BigDecimal("120").setScale(2), LocalDate.now(),"Medio", "18kg","luxo",
                Status.DISPONIVEL, Avaliacao.UMAESTRELA,  estabelecimento01, vendedor01);

        vendedorRepository.save(vendedor01);
        estabelecimentoRepository.save(estabelecimento01);
        produtoRepository.save(produto01);
    }
}
