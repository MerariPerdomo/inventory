package org.karemeru.empresa.aplicacion.port.in;

import java.util.UUID;

public interface CrearEmpresaUseCase {
    UUID ejecutar(CrearEmpresaComando comando);
}
