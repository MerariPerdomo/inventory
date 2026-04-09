package org.karemeru.empresa.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import org.karemeru.empresa.dominio.Empresa;
import org.karemeru.empresa.dominio.vo.*;
import org.karemeru.empresa.infraestructura.entidad.EmpresaEntidad;

@ApplicationScoped
public class EmpresaMapper {

    public EmpresaEntidad toEntidad(Empresa empresa) {
        var entidad = new EmpresaEntidad();
        entidad.idEmpresa = empresa.getIdEmpresa();
        entidad.nombre = String.valueOf(empresa.getNombre().valor());
        entidad.estado = empresa.getEstado().name();
        entidad.identificador = empresa.getIdentificador().valor();
        entidad.calle = empresa.getDireccion().calle();
        entidad.ciudad = empresa.getDireccion().ciudad();
        entidad.pais = empresa.getDireccion().pais();
        entidad.telefono = empresa.getContacto().telefono();
        entidad.email = empresa.getContacto().email();
        entidad.fechaCreacion = empresa.getFechaCreacion();
        entidad.fechaModificacion = empresa.getFechaModificacion();
        return entidad;
    }

    public Empresa toDominio(EmpresaEntidad e) {
        return new Empresa(
                e.idEmpresa,
                new Nombre(e.nombre),
                Estado.valueOf(e.estado),
                new Direccion(e.calle,e.ciudad,e.pais),
                new Contacto(e.email,e.telefono),
                new Identificador(e.identificador),
                e.fechaModificacion
        );
    }
}
