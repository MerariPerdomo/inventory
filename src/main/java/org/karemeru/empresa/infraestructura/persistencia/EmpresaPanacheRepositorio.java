package org.karemeru.empresa.infraestructura.persistencia;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.karemeru.empresa.infraestructura.entidad.EmpresaEntidad;

import java.util.UUID;

@ApplicationScoped
public class EmpresaPanacheRepositorio implements
        PanacheRepositoryBase<EmpresaEntidad, UUID> {

}
