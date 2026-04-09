package org.karemeru.empresa.dominio.vo;

public record Nombre(String valor) {
    public Nombre {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El nombre no es valido");
        }
    }
}
