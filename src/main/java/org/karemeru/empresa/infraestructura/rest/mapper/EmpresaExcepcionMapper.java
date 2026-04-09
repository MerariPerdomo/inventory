package org.karemeru.empresa.infraestructura.rest.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.karemeru.empresa.dominio.excepcion.EmpresaExistenteExcepcion;

@Provider
public class EmpresaExcepcionMapper implements ExceptionMapper<EmpresaExistenteExcepcion> {


    public Response toResponse(EmpresaExistenteExcepcion excepcion) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponse(excepcion.getMessage()))
                .build();
    }

    public record ErrorResponse(String mensaje) {}
}
