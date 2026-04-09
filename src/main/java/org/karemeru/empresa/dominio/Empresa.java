package org.karemeru.empresa.dominio;

import org.karemeru.empresa.dominio.vo.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Empresa {
    UUID idEmpresa;
    Nombre nombre;
    Estado estado;
    Direccion direccion;
    Contacto contacto;
    Identificador identificador;
    LocalDateTime fechaCreacion;
    LocalDateTime fechaModificacion;

    public Empresa(UUID idEmpresa,
                   Nombre nombre,
                   Estado estado,
                   Direccion direccion,
                   Contacto contacto,
                   Identificador identificador,
                   LocalDateTime fechaCreacion) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.estado = estado;
        this.direccion = direccion;
        this.contacto = contacto;
        this.identificador = identificador;
        this.fechaCreacion = fechaCreacion;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = nombre;
        this.fechaModificacion = LocalDateTime.now();
    }

    public UUID getIdEmpresa() {
        return idEmpresa;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
}
