package com.prova.Produto.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.Produto.domains.dtos.VendedorDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vendedor")
    private Integer idVendedor;

    @NotNull @NotBlank
    private String nomeVendedor;

    @NotNull @NotBlank
    @Column (unique = true)
    private String cpf;

    @NotNull @NotBlank
    @Column (unique = true)
    private String rg;

    @NotNull @NotBlank
    private String cep;

    @NotNull @NotBlank
    private String cargo;

    @NotNull @NotBlank
    private String salario;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor, String nomeVendedor, String cpf, String rg, String cep, String cargo, String salario) {
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Vendedor(VendedorDTO dto){
        this.idVendedor = dto.getIdVendedor();
        this.nomeVendedor = dto.getNomeVendedor();
        this.cpf = dto.getCpf();
        this.rg = dto.getRg();
        this.cep = dto.getCep();
        this.cargo = dto.getCargo();
        this.salario = dto.getSalario();
    }


    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public @NotNull @NotBlank String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(@NotNull @NotBlank String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull @NotBlank String getRg() {
        return rg;
    }

    public void setRg(@NotNull @NotBlank String rg) {
        this.rg = rg;
    }

    public @NotNull @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotNull @NotBlank String cep) {
        this.cep = cep;
    }

    public @NotNull @NotBlank String getCargo() {
        return cargo;
    }

    public void setCargo(@NotNull @NotBlank String cargo) {
        this.cargo = cargo;
    }

    public @NotNull @NotBlank String getSalario() {
        return salario;
    }

    public void setSalario(@NotNull @NotBlank String salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(idVendedor, vendedor.idVendedor) && Objects.equals(nomeVendedor, vendedor.nomeVendedor) && Objects.equals(cpf, vendedor.cpf) && Objects.equals(rg, vendedor.rg) && Objects.equals(cep, vendedor.cep) && Objects.equals(cargo, vendedor.cargo) && Objects.equals(salario, vendedor.salario) && Objects.equals(produtos, vendedor.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVendedor, nomeVendedor, cpf, rg, cep, cargo, salario, produtos);
    }
}

