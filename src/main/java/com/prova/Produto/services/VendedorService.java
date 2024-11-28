package com.prova.Produto.services;

import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.dtos.VendedorDTO;
import com.prova.Produto.repositories.VendedorRepository;
import com.prova.Produto.services.exceptions.DataIntegrityViolationException;
import com.prova.Produto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepo;

    public List<VendedorDTO> findAll(){
        return vendedorRepo.findAll().stream().map(obj -> new VendedorDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public Vendedor findbyId( int id){
        Optional<Vendedor> obj = vendedorRepo.findById(id);
        return obj.orElse(null);
    }

    public Vendedor findbyCpf (String cpf){
        Optional<Vendedor> obj = vendedorRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("CPF não encontrado CPF:" + cpf));
    }

    public Vendedor findbyRg(String rg){
        Optional<Vendedor> obj = vendedorRepo.findByRg(rg);
        return obj.orElseThrow(() -> new ObjectNotFoundException("RG não encontrado RG:" + rg));
    }



    public  Vendedor create (VendedorDTO dto){
        dto.setIdVendedor(null);
        validaVendedorCpf(dto);
        validaVendedorRg(dto);
        Vendedor obj = new Vendedor(dto);
        return vendedorRepo.save(obj);
    }

    private void validaVendedorCpf(VendedorDTO dto){
        Optional<Vendedor> obj = vendedorRepo.findByCpf(dto.getCpf());
        if(obj.isPresent() && obj.get().getIdVendedor() != dto.getIdVendedor()){
            throw new DataIntegrityViolationException("Cpf já cadastrado");
        }
    }

    private void validaVendedorRg(VendedorDTO dto){
        Optional<Vendedor> obj = vendedorRepo.findByRg(dto.getRg());
        if(obj.isPresent() && obj.get().getIdVendedor() != dto.getIdVendedor()){
            throw new DataIntegrityViolationException("Rg já cadastrado");
        }
    }

    public  Vendedor update(Integer id, VendedorDTO objDto){
        objDto.setIdVendedor(id);
        Vendedor oldObj = findbyId(id);
        oldObj = new Vendedor(objDto);
        return  vendedorRepo.save(oldObj);
    }

    public void delete(Integer id){
        Vendedor obj = findbyId(id);
        if (obj.getProdutos().size()>0){
            throw  new DataIntegrityViolationException("O vendedor não pode ser deletado, pois tem um produto cadastrada nele");

        }
        vendedorRepo.deleteById(id);
    }




}
