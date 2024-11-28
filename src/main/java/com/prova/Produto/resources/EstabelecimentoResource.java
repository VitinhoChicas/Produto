package com.prova.Produto.resources;


import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.dtos.EstabelecimentoDTO;
import com.prova.Produto.services.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDTO>> findAll(){
        return  ResponseEntity.ok().body(estabelecimentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> findById(@PathVariable Integer id){
        Estabelecimento obj = this.estabelecimentoService.findbyId(id);
        return  ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<EstabelecimentoDTO> findByCnpj(@PathVariable  String cnpj){
        Estabelecimento obj = this.estabelecimentoService.findbyCnpj(cnpj);
        return  ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }

    @PostMapping ResponseEntity<EstabelecimentoDTO> create(@Valid @RequestBody EstabelecimentoDTO dto){
        Estabelecimento estabelecimento = estabelecimentoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(estabelecimento.getIdEstabelecimento()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<EstabelecimentoDTO> update(@PathVariable Integer id, @Valid @RequestBody EstabelecimentoDTO objDto) {
        Estabelecimento Obj = estabelecimentoService.update(id, objDto);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> delete(@PathVariable Integer id){
        estabelecimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
