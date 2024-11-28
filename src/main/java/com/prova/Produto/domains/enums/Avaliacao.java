package com.prova.Produto.domains.enums;


public enum Avaliacao {

    UMAESTRELA(1, "Uma estrela "), DUASESTRELAS(2, "Duas estrelas"), TRESESTRELAS(3, "Tres estrelas"), QUATROESTRELAS(4, "Quatro estrelas"), CINCOESTRELAS(5, "Cinco estrelas");
    private Integer id;
    private String descricao;

    Avaliacao(Integer id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Avaliacao toEnum(Integer id){
        if (id==null) return null;
        for (Avaliacao c : Avaliacao.values()){ //Para cada valor c presente em Conservacao.values(), faça o bloco de código que segue
            if (id.equals(c.getId())){ // se o id do valor c for igual ao id que está sendo comparado
                return c; //retorne o valor correspondente de Conservacao
            }
        }

        throw new IllegalArgumentException("Conservação inválida");
    }
}

