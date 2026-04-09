package org.karemeru.empresa.aplicacion.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import org.karemeru.empresa.aplicacion.port.in.ListarEmpresasCasoUso;
import org.karemeru.empresa.aplicacion.port.out.EmpresaRepositorio;
import org.karemeru.empresa.dominio.Empresa;

import java.util.List;
@ApplicationScoped
public class ListarEmpresaServicio implements ListarEmpresasCasoUso {
    private final EmpresaRepositorio repositorio;

    public ListarEmpresaServicio(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public List<Empresa> ejecutar() {
        return repositorio.buscarTodos();
    }
}
