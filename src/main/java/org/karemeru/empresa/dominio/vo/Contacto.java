package org.karemeru.empresa.dominio.vo;


public record Contacto(String email, String telefono) {
    public Contacto {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El email no es valido");
        }
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            throw new IllegalArgumentException("El email no es valido");
        }
        if (telefono != null && !telefono.isBlank() && !telefono.contains("-")) {
            throw new IllegalArgumentException("El telefono no es valido");
        }
        if (telefono != null && !telefono.isBlank()
                && !telefono.matches("^[0-9+\\-() ]{7,15}$")) {
            throw new IllegalArgumentException("El telefono no es valido");
        }

        email = email.toLowerCase().trim();
        telefono = (telefono != null) ? telefono.trim() : null;
    }
}
