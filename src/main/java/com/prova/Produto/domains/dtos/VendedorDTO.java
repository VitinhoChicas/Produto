package com.prova.Produto.domains.dtos;

import com.prova.Produto.domains.Vendedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VendedorDTO {

    private Integer idVendedor;

    @NotBlank(message = "O campo nome não pode ser vazio")
    @NotNull(message = "O campo nome não pode ser nulo")
    private String nomeVendedor;

    @NotBlank(message = "O campo cpf não pode ser vazio")
    @NotNull(message = "O campo cpf não pode ser nulo")
    private String cpf;

    @NotBlank(message = "O campo rg não pode ser vazio")
    @NotNull(message = "O campo rg não pode ser nulo")
    private String rg;

    @NotBlank(message = "O campo cep não pode ser vazio")
    @NotNull(message = "O campo cep não pode ser nulo")
    private String cep;

    @NotBlank(message = "O campo cargo não pode ser vazio")
    @NotNull(message = "O campo cargo não pode ser nulo")
    private String cargo;

    @NotBlank(message = "O campo salario não pode ser vazio")
    @NotNull(message = "O campo salario não pode ser nulo")
    private String salario;

    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor){
        this.idVendedor = vendedor.getIdVendedor();
        this.nomeVendedor = vendedor.getNomeVendedor();
        this.cpf = vendedor.getCpf();
        this.rg = vendedor.getRg();
        this.cep = vendedor.getCep();
        this.cargo = vendedor.getCargo();
        this.salario = vendedor.getSalario();
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public @NotBlank(message = "O campo nome não pode ser vazio") @NotNull(message = "O campo nome não pode ser nulo") String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(@NotBlank(message = "O campo nome não pode ser vazio") @NotNull(message = "O campo nome não pode ser nulo") String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public @NotBlank(message = "O campo cpf não pode ser vazio") @NotNull(message = "O campo cpf não pode ser nulo") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O campo cpf não pode ser vazio") @NotNull(message = "O campo cpf não pode ser nulo") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O campo rg não pode ser vazio") @NotNull(message = "O campo rg não pode ser nulo") String getRg() {
        return rg;
    }

    public void setRg(@NotBlank(message = "O campo rg não pode ser vazio") @NotNull(message = "O campo rg não pode ser nulo") String rg) {
        this.rg = rg;
    }

    public @NotBlank(message = "O campo cep não pode ser vazio") @NotNull(message = "O campo cep não pode ser nulo") String getCep() {
        return cep;
    }

    public void setCep(@NotBlank(message = "O campo cep não pode ser vazio") @NotNull(message = "O campo cep não pode ser nulo") String cep) {
        this.cep = cep;
    }

    public @NotBlank(message = "O campo cargo não pode ser vazio") @NotNull(message = "O campo cargo não pode ser nulo") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "O campo cargo não pode ser vazio") @NotNull(message = "O campo cargo não pode ser nulo") String cargo) {
        this.cargo = cargo;
    }

    public @NotBlank(message = "O campo salario não pode ser vazio") @NotNull(message = "O campo salario não pode ser nulo") String getSalario() {
        return salario;
    }

    public void setSalario(@NotBlank(message = "O campo salario não pode ser vazio") @NotNull(message = "O campo salario não pode ser nulo") String salario) {
        this.salario = salario;
    }
}
