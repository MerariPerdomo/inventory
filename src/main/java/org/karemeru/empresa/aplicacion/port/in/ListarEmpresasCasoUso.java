package org.karemeru.empresa.aplicacion.port.in;

import org.karemeru.empresa.dominio.Empresa;

import java.util.List;

public interface ListarEmpresasCasoUso {
    List<Empresa> ejecutar();
}
