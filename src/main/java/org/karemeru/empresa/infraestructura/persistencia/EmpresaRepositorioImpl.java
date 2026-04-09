package org.karemeru.empresa.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import org.karemeru.empresa.aplicacion.port.out.EmpresaRepositorio;
import org.karemeru.empresa.dominio.Empresa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class EmpresaRepositorioImpl implements EmpresaRepositorio {

    private final EmpresaMapper mapper;
    private final EmpresaPanacheRepositorio panache;

    public EmpresaRepositorioImpl(EmpresaMapper mapper,
                                  EmpresaPanacheRepositorio panache) {
        this.mapper = mapper;
        this.panache = panache;
    }

    @Override
    public void guardar(Empresa empresa) {
        panache.persist(mapper.toEntidad(empresa));
    }

    @Override
    public Optional<Empresa> buscarPorId(UUID id) {
        return panache.findByIdOptional(id)
                .map(mapper::toDominio);
    }

    @Override
    public Optional<Empresa> buscarPorIdentificador(String identificador) {
        return panache.find("identificador", identificador)
                .firstResultOptional()
                .map(mapper::toDominio);
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return panache.count("identificador", identificador) > 0;
    }

    @Override
    public List<Empresa> buscarTodos() {
        return panache.listAll()
                .stream()
                .map(mapper::toDominio)
                .toList();
    }
}
