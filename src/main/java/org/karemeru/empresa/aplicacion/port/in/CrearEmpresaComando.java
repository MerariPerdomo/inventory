package org.karemeru.empresa.aplicacion.port.in;

public record CrearEmpresaComando(String nombre,
                                  String identificador,
                                  String calle,
                                  String ciudad,
                                  String pais,
                                  String telefono,
                                  String email)
{}
