package com.prova.Produto.services;


import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.Produto;
import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.dtos.ProdutoDTO;
import com.prova.Produto.repositories.EstabelecimentoRepository;
import com.prova.Produto.repositories.ProdutoRepository;
import com.prova.Produto.repositories.VendedorRepository;
import com.prova.Produto.services.exceptions.DataIntegrityViolationException;
import com.prova.Produto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private EstabelecimentoRepository ediRepo;

    @Autowired
    private VendedorRepository vendedorRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll(){
        return produtoRepo.findAll().stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
    }

    public Produto findbyId(Long id){
        Optional<Produto> obj = produtoRepo.findById(id);
        return obj.orElseThrow(() -> new  ObjectNotFoundException("Livro não encontrado Id:" + id));
    }

    public Produto findbyDescricao(String descricao){
        Optional<Produto> obj = produtoRepo.findByDescricao(descricao);
        return obj.orElseThrow(() -> new  ObjectNotFoundException("Livro não encontrado Descricao:" + descricao));
    }

    public Produto create(ProdutoDTO dto){
        dto.setIdProduto(null);
        validaProduto(dto);
        Produto obj = new Produto(dto);
        return produtoRepo.save(obj);
    }

    private void validaProduto(ProdutoDTO dto){
        Optional<Produto> obj = produtoRepo.findByDescricao(dto.getDescricao());
        if(obj.isPresent() && obj.get().getIdProduto() != dto.getIdProduto()){
            throw new DataIntegrityViolationException("Descrição já cadastrada");
        }


        Optional<Vendedor> vendedor = vendedorRepo.findById(dto.getVendedor());
        if(!vendedor.isPresent()){
            throw new DataIntegrityViolationException("Vendedor - " + dto.getVendedor() + "não esta cadastrado");
        }

        Optional<Estabelecimento> estabelecimento = ediRepo.findById(dto.getEstabelecimento());
        if(!estabelecimento.isPresent()){
            throw new DataIntegrityViolationException("Estabelecimento - " + dto.getEstabelecimento() + "não esta cadastrado");
        }
    }


    public Produto update(Long id, ProdutoDTO objDto){
        objDto.setIdProduto(id);
        Produto oldObj = findbyId(id);
        oldObj = new Produto(objDto);
        validaProduto(objDto);
        return  produtoRepo.save(oldObj);
    }

    public void delete(Long id){
        Produto obj = findbyId(id);
        produtoRepo.deleteById(id);
    }







}
