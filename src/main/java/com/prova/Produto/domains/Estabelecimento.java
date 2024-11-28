package com.prova.Produto.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.Produto.domains.dtos.EstabelecimentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estabelecimento")

public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_estabelecimento")
    private Integer idEstabelecimento;

    @NotBlank @NotNull
    @Column (unique = true)
    private String cnpj;

    @NotBlank @NotNull
    private String nomeEstabelecimento;

    @NotBlank @NotNull
    private String endereco;

    @NotBlank @NotNull
    private String cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "estabelecimento")
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Estabelecimento() {
    }


    public Estabelecimento(Integer idEstabelecimento, String cnpj, String nomeEstabelecimento, String endereco, String cidade) {
        this.idEstabelecimento = idEstabelecimento;
        this.cnpj = cnpj;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.endereco = endereco;
        this.cidade = cidade;

    }

    public Estabelecimento(EstabelecimentoDTO dto){
        this.idEstabelecimento = dto.getIdEstabelecimento();
        this.cnpj = dto.getCnpj();
        this.nomeEstabelecimento = dto.getNomeEstabelecimento();
        this.endereco = dto.getEndereco();
        this.cidade = dto.getCidade();
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public @NotBlank @NotNull String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank @NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank @NotNull String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(@NotBlank @NotNull String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public @NotBlank @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank @NotNull String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank @NotNull String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank @NotNull String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(idEstabelecimento, that.idEstabelecimento) && Objects.equals(cnpj, that.cnpj) && Objects.equals(nomeEstabelecimento, that.nomeEstabelecimento) && Objects.equals(endereco, that.endereco) && Objects.equals(cidade, that.cidade) && Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstabelecimento, cnpj, nomeEstabelecimento, endereco, cidade, produtos);
    }
}
