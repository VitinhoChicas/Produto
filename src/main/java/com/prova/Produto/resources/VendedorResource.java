package com.prova.Produto.resources;


import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.dtos.VendedorDTO;
import com.prova.Produto.services.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorResource {


    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> findAll(){
        return ResponseEntity.ok().body(vendedorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> findByid(@PathVariable Integer id){
        Vendedor obj = this.vendedorService.findbyId(id);
        return ResponseEntity.ok().body(new VendedorDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<VendedorDTO> findByCpf(@PathVariable String cpf){
        Vendedor obj = this.vendedorService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new VendedorDTO(obj));
    }

    @GetMapping(value = "/rg/{rg}")
    public ResponseEntity<VendedorDTO> findByRg(@PathVariable String rg){
        Vendedor obj = this.vendedorService.findbyRg(rg);
        return ResponseEntity.ok().body(new VendedorDTO(obj));
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> create(@Valid @RequestBody VendedorDTO dto){
        Vendedor vendedor = vendedorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedor.getIdVendedor()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Integer id, @Valid @RequestBody VendedorDTO objtDto){
        Vendedor Obj = vendedorService.update(id, objtDto);
        return ResponseEntity.ok().body(new VendedorDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<VendedorDTO> delete(@PathVariable Integer id){
        vendedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
