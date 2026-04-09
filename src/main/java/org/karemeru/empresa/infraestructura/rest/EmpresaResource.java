package org.karemeru.empresa.infraestructura.rest;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.karemeru.empresa.aplicacion.port.in.CrearEmpresaComando;
import org.karemeru.empresa.aplicacion.port.in.CrearEmpresaUseCase;
import org.karemeru.empresa.aplicacion.port.in.ListarEmpresasCasoUso;
import org.karemeru.empresa.dominio.vo.Identificador;
import org.karemeru.empresa.dominio.vo.Nombre;
import org.karemeru.empresa.infraestructura.rest.dto.EmpresaRequest;
import org.karemeru.empresa.infraestructura.rest.dto.EmpresaResponse;

@Path("/empresas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaResource {
    private final CrearEmpresaUseCase crearEmpresa;
    private final ListarEmpresasCasoUso listarEmpresasCasoUso;

    public EmpresaResource(CrearEmpresaUseCase crearEmpresa,
                           ListarEmpresasCasoUso listarEmpresaCasoUso) {
        this.crearEmpresa = crearEmpresa;
        this.listarEmpresasCasoUso = listarEmpresaCasoUso;
    }

    @POST
    public Response crear(@Valid EmpresaRequest request) {
        var comando = new CrearEmpresaComando(
                request.nombre(),
                request.identificador(),
                request.calle(),
                request.ciudad(),
                request.pais(),
                request.telefono(),
                request.email()
        );

        var id = crearEmpresa.ejecutar(comando);

        var uri = UriBuilder.fromResource(EmpresaResource.class)
                .path(id.toString())
                .build();

        return Response.created(uri)
                .entity(new EmpresaResponse(id,
                        comando.nombre(),
                        comando.identificador(),
                        comando.email(),
                        comando.telefono(),
                        comando.ciudad(),
                        comando.pais()))
                .build();
    }

    @GET
    public Response listar() {

        var empresas = listarEmpresasCasoUso.ejecutar();

        var response = empresas.stream()
                .map(e -> new EmpresaResponse(
                        e.getIdEmpresa(),
                        e.getNombre().valor(),
                        e.getIdentificador().valor(),
                        e.getContacto().email(),
                        e.getContacto().telefono(),
                        e.getDireccion().ciudad(),
                        e.getDireccion().pais()))
                .toList();

        return Response.ok(response).build();
    }
}
