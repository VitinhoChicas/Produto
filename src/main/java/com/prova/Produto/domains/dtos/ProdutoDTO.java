package com.prova.Produto.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.Produto.domains.Estabelecimento;
import com.prova.Produto.domains.Produto;
import com.prova.Produto.domains.Vendedor;
import com.prova.Produto.domains.enums.Avaliacao;
import com.prova.Produto.domains.enums.Status;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoDTO {

    private Long idProduto;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descircao não pode ser vazio")
    private  String descricao;

    @NotNull(message = "O campo quantidade vendido não pode ser nulo")
    private  int qtdVendido;

    @NotNull(message = "O campo valUnit não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valUnit;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataExposicao;

    @NotNull(message = "O campo tamanho não pode ser nulo")
    @NotBlank(message = "O campo tamanho não pode ser vazio")
    private  String tamanho;

    @NotNull(message = "O campo peso não pode ser nulo")
    @NotBlank(message = "O campo peso não pode ser vazio")
    private  String peso;

    @NotNull(message = "O campo categoria não pode ser nulo")
    @NotBlank(message = "O campo categoria não pode ser vazio")
    private  String categoria;

    private int status;
    private  int avaliacao;

    @NotNull(message = "O campo Estabelecimento é requerido")
    private int Estabelecimento;

    @NotNull(message = "O campo Vendedor é requirido")
    private int Vendedor;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto){
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.qtdVendido = produto.getQtdVendido();
        this.valUnit = produto.getValUnit();
        this.dataExposicao = produto.getDataExposicao();
        this.tamanho = produto.getTamanho();
        this.peso = produto.getPeso();
        this.categoria = produto.getCategoria();

        this.status  = produto.getStatus().getId();
        this.avaliacao = produto.getAvaliacao().getId();
        Estabelecimento = produto.getEstabelecimento().getIdEstabelecimento();
        Vendedor  = produto.getVendedor().getIdVendedor();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descircao não pode ser vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descircao não pode ser vazio") String descricao) {
        this.descricao = descricao;
    }

    @NotNull(message = "O campo quantidade vendido não pode ser nulo")
    public int getQtdVendido() {
        return qtdVendido;
    }

    public void setQtdVendido(@NotNull(message = "O campo quantidade vendido não pode ser nulo") int qtdVendido) {
        this.qtdVendido = qtdVendido;
    }

    public @NotNull(message = "O campo valUnit não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getValUnit() {
        return valUnit;
    }

    public void setValUnit(@NotNull(message = "O campo valUnit não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal valUnit) {
        this.valUnit = valUnit;
    }

    public LocalDate getDataExposicao() {
        return dataExposicao;
    }

    public void setDataExposicao(LocalDate dataExposicao) {
        this.dataExposicao = dataExposicao;
    }

    public @NotNull(message = "O campo tamanho não pode ser nulo") @NotBlank(message = "O campo tamanho não pode ser vazio") String getTamanho() {
        return tamanho;
    }

    public void setTamanho(@NotNull(message = "O campo tamanho não pode ser nulo") @NotBlank(message = "O campo tamanho não pode ser vazio") String tamanho) {
        this.tamanho = tamanho;
    }

    public @NotNull(message = "O campo peso não pode ser nulo") @NotBlank(message = "O campo peso não pode ser vazio") String getPeso() {
        return peso;
    }

    public void setPeso(@NotNull(message = "O campo peso não pode ser nulo") @NotBlank(message = "O campo peso não pode ser vazio") String peso) {
        this.peso = peso;
    }

    public @NotNull(message = "O campo categoria não pode ser nulo") @NotBlank(message = "O campo categoria não pode ser vazio") String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull(message = "O campo categoria não pode ser nulo") @NotBlank(message = "O campo categoria não pode ser vazio") String categoria) {
        this.categoria = categoria;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @NotNull(message = "O campo Estabelecimento é requerido")
    public int getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(@NotNull(message = "O campo Estabelecimento é requerido") int estabelecimento) {
        Estabelecimento = estabelecimento;
    }

    @NotNull(message = "O campo Vendedor é requirido")
    public int getVendedor() {
        return Vendedor;
    }

    public void setVendedor(@NotNull(message = "O campo Vendedor é requirido") int vendedor) {
        Vendedor = vendedor;
    }
}
