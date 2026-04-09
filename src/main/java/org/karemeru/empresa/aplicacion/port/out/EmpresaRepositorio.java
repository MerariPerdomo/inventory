package org.karemeru.empresa.aplicacion.port.out;

import jakarta.enterprise.context.ApplicationScoped;
import org.karemeru.empresa.dominio.Empresa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@ApplicationScoped
public interface EmpresaRepositorio {
    void guardar(Empresa empresa);

    Optional<Empresa> buscarPorId(UUID id);

    Optional<Empresa> buscarPorIdentificador(String identificador);
    boolean existePorIdentificador(String identificador);

    List<Empresa> buscarTodos();
}
