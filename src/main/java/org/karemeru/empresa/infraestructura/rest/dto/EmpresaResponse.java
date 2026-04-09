package org.karemeru.empresa.infraestructura.rest.dto;

import org.karemeru.empresa.dominio.vo.Contacto;
import org.karemeru.empresa.dominio.vo.Direccion;
import org.karemeru.empresa.dominio.vo.Identificador;
import org.karemeru.empresa.dominio.vo.Nombre;

import java.util.UUID;

public record EmpresaResponse(UUID idEmpresa,
                              String nombre,
                              String identificador,
                              String email,
                              String telefono,
                              String ciudad,
                              String pais) {
}
