package com.prova.Produto.services;

import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.dtos.EstabelecimentoDTO;
import com.prova.Produto.domains.dtos.VendedorDTO;
import com.prova.Produto.repositories.EstabelecimentoRepository;
import com.prova.Produto.services.exceptions.DataIntegrityViolationException;
import com.prova.Produto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository ediRepo;


    public List<EstabelecimentoDTO> findAll(){
        return ediRepo.findAll().stream().map(obj -> new EstabelecimentoDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public Estabelecimento findbyId (int id){
        Optional<Estabelecimento> obj = ediRepo.findById(id);
        return  obj.orElseThrow(() -> new ObjectNotFoundException(" Estabelecimento não encontrado!  Id: " +id));
    }

    public Estabelecimento findbyCnpj (String cnpj){
        Optional<Estabelecimento> obj = ediRepo.findByCnpj(cnpj);
        return  obj.orElseThrow(() -> new ObjectNotFoundException(" Estabelecimento não encontrado!  Cnpj: " +cnpj));
    }



    public Estabelecimento create (EstabelecimentoDTO dto){
        dto.setIdEstabelecimento(null);
        validaEstabelecimento(dto);
        Estabelecimento obj = new Estabelecimento(dto);
        return ediRepo.save(obj);
    }

    private void validaEstabelecimento(EstabelecimentoDTO dto){
        Optional<Estabelecimento> obj = ediRepo.findByCnpj(dto.getCnpj());
        if(obj.isPresent() && obj.get().getIdEstabelecimento() != dto.getIdEstabelecimento()){
            throw new DataIntegrityViolationException("Cnpj já cadastrado");
        }
    }

    public  Estabelecimento update(Integer id, EstabelecimentoDTO objDto){
        objDto.setIdEstabelecimento(id);
        Estabelecimento oldObj = findbyId(id);
        oldObj = new Estabelecimento(objDto);
        validaEstabelecimento(objDto);
        return  ediRepo.save(oldObj);
    }

    public void delete(Integer id){
        Estabelecimento obj = findbyId(id);
        if (obj.getProdutos().size()>0){
            throw  new DataIntegrityViolationException("O Estabelecimento não pode ser deletado, pois tem um produto cadastrada nele");

        }
        ediRepo.deleteById(id);
    }











}
