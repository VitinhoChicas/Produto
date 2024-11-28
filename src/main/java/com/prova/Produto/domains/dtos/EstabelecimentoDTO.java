package com.prova.Produto.domains.dtos;

import com.prova.Produto.domains.Estabelecimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstabelecimentoDTO {

    private Integer idEstabelecimento;

    @NotNull(message = "O campo cnpj não pode ser nulo")
    @NotBlank(message = "O campo cnpj não pode ser vazio")
    private String cnpj;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nomeEstabelecimento;

    @NotNull(message = "O campo endereco não pode ser nulo")
    @NotBlank(message = "O campo endereco não pode ser vazio")
    private String endereco;

    @NotNull(message = "O campo cidade não pode ser nulo")
    @NotBlank(message = "O campo cidade não pode ser vazio")
    private String cidade;

    public EstabelecimentoDTO() {
    }

    public EstabelecimentoDTO(Estabelecimento estabelecimento){
        this.idEstabelecimento = estabelecimento.getIdEstabelecimento();
        this.cnpj = estabelecimento.getCnpj();
        this.nomeEstabelecimento = estabelecimento.getNomeEstabelecimento();
        this.endereco = estabelecimento.getEndereco();
        this.cidade = estabelecimento.getCidade();
    }

    public Integer getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Integer idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public @NotNull(message = "O campo cnpj não pode ser nulo") @NotBlank(message = "O campo cnpj não pode ser vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo") @NotBlank(message = "O campo cnpj não pode ser vazio") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode ser vazio") String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode ser vazio") String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public @NotNull(message = "O campo endereco não pode ser nulo") @NotBlank(message = "O campo endereco não pode ser vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser nulo") @NotBlank(message = "O campo endereco não pode ser vazio") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo cidade não pode ser nulo") @NotBlank(message = "O campo cidade não pode ser vazio") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "O campo cidade não pode ser nulo") @NotBlank(message = "O campo cidade não pode ser vazio") String cidade) {
        this.cidade = cidade;
    }
}
