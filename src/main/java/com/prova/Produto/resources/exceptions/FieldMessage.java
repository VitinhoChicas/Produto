package com.prova.Produto.resources.exceptions;

public class FieldMessage {

     private String fieldName;
     private String menssage;

     public FieldMessage(){super();}

    public FieldMessage(String fieldName, String menssage) {
        this.fieldName = fieldName;
        this.menssage = menssage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }
}
