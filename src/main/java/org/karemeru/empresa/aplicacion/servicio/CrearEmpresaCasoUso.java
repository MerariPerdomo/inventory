package org.karemeru.empresa.aplicacion.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.karemeru.empresa.aplicacion.port.in.CrearEmpresaComando;
import org.karemeru.empresa.aplicacion.port.in.CrearEmpresaUseCase;
import org.karemeru.empresa.aplicacion.port.out.EmpresaRepositorio;
import org.karemeru.empresa.dominio.Empresa;
import org.karemeru.empresa.dominio.excepcion.EmpresaExistenteExcepcion;
import org.karemeru.empresa.dominio.vo.*;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CrearEmpresaCasoUso implements CrearEmpresaUseCase {

    private final EmpresaRepositorio repositorio;

    public CrearEmpresaCasoUso(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional
    public UUID ejecutar(CrearEmpresaComando comando) {
        if(repositorio.existePorIdentificador(comando.identificador())){
            throw new EmpresaExistenteExcepcion(comando.identificador());
        }

        var empresa = new Empresa(
                UUID.randomUUID(),
                new Nombre(comando.nombre()),
                Estado.ACTIVA,
                new Direccion(comando.calle(), comando.ciudad(), comando.pais()),
                new Contacto(comando.email(), comando.telefono()),
                new Identificador(comando.identificador()),
                LocalDateTime.now()
        );

        repositorio.guardar(empresa);
        return empresa.getIdEmpresa();
    }
}
