package org.karemeru.empresa.dominio.vo;

public record Identificador(String valor) {
    public Identificador{
        if(valor == null || valor.isBlank()){
            throw new IllegalArgumentException("Identificador vacío");
        }
        if(!valor.matches("^[a-z0-9-]+$")){
            throw new IllegalArgumentException("Formato invalido");
        }
    }
}
