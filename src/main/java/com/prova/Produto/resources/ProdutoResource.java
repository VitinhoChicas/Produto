package com.prova.Produto.resources;


import com.prova.Produto.domains.Produto;
import com.prova.Produto.domains.dtos.ProdutoDTO;
import com.prova.Produto.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        Produto obj = this.produtoService.findbyId(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @GetMapping(value = "/descricao/{descricao}")
    public ResponseEntity<ProdutoDTO> findByDescricao(@PathVariable String descricao){
        Produto obj = this.produtoService.findbyDescricao(descricao);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO dto){
        Produto produto = produtoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getIdProduto()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO objDto){
        Produto Obj = produtoService.update(id, objDto);
        return  ResponseEntity.ok().body(new ProdutoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id){
        produtoService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
