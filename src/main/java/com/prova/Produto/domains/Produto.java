package com.prova.Produto.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.Produto.domains.dtos.ProdutoDTO;
import com.prova.Produto.domains.enums.Avaliacao;
import com.prova.Produto.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idProduto;

    @NotNull @NotBlank
    @Column(unique = true)
    private String descricao;

    @NotNull
    private int qtdVendido;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valUnit;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataExposicao = LocalDate.now();

    @NotNull @NotBlank
    private String tamanho;

    @NotNull @NotBlank
    private String peso;

    @NotNull @NotBlank
    private String categoria;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "avaliacao")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "idestabelecimento")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;

    public Produto() {
        this.valUnit = BigDecimal.ZERO;
        this.status = Status.DISPONIVEL;
        this.avaliacao = Avaliacao.UMAESTRELA;
    }

    public Produto(Long idProduto, String descricao, int qtdVendido, BigDecimal valUnit, LocalDate dataExposicao, String tamanho, String peso, String categoria, Status status, Avaliacao avaliacao, Estabelecimento estabelecimento, Vendedor vendedor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.qtdVendido = qtdVendido;
        this.valUnit = valUnit;
        this.dataExposicao = dataExposicao;
        this.tamanho = tamanho;
        this.peso = peso;
        this.categoria = categoria;
        this.status = status;
        this.avaliacao = avaliacao;
        this.estabelecimento = estabelecimento;
        this.vendedor = vendedor;
    }

    public Produto(ProdutoDTO dto){
        this.idProduto = dto.getIdProduto();
        this.descricao = dto.getDescricao();
        this.qtdVendido = dto.getQtdVendido();
        this.valUnit = dto.getValUnit();
        this.dataExposicao = dto.getDataExposicao();
        this.tamanho = dto.getTamanho();
        this.peso = dto.getPeso();
        this.categoria = dto.getCategoria();

        this.estabelecimento = new Estabelecimento();
        this.estabelecimento.setIdEstabelecimento(dto.getEstabelecimento());
        this.vendedor = new Vendedor();
        this.vendedor.setIdVendedor(dto.getVendedor());
        this.status  = Status.toEnum(dto.getStatus());
        this.avaliacao = Avaliacao.toEnum(dto.getAvaliacao());
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }


    @NotNull
    public int getQtdVendido() {
        return qtdVendido;
    }

    public void setQtdVendido(@NotNull int qtdVendido) {
        this.qtdVendido = qtdVendido;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getValUnit() {
        return valUnit;
    }

    public void setValUnit(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valUnit) {
        this.valUnit = valUnit;
    }

    public LocalDate getDataExposicao() {
        return dataExposicao;
    }

    public void setDataExposicao(LocalDate dataExposicao) {
        this.dataExposicao = dataExposicao;
    }

    public @NotNull @NotBlank String getTamanho() {
        return tamanho;
    }

    public void setTamanho(@NotNull @NotBlank String tamanho) {
        this.tamanho = tamanho;
    }

    public @NotNull @NotBlank String getPeso() {
        return peso;
    }

    public void setPeso(@NotNull @NotBlank String peso) {
        this.peso = peso;
    }

    public @NotNull @NotBlank String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull @NotBlank String categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return qtdVendido == produto.qtdVendido && Objects.equals(idProduto, produto.idProduto) && Objects.equals(descricao, produto.descricao) && Objects.equals(valUnit, produto.valUnit) && Objects.equals(dataExposicao, produto.dataExposicao) && Objects.equals(tamanho, produto.tamanho) && Objects.equals(peso, produto.peso) && Objects.equals(categoria, produto.categoria) && Objects.equals(status, produto.status) && Objects.equals(avaliacao, produto.avaliacao) && Objects.equals(estabelecimento, produto.estabelecimento) && Objects.equals(vendedor, produto.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, descricao, qtdVendido, valUnit, dataExposicao, tamanho, peso, categoria, status, avaliacao, estabelecimento, vendedor);
    }
}