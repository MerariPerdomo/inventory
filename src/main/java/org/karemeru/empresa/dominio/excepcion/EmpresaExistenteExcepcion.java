package org.karemeru.empresa.dominio.excepcion;

public class EmpresaExistenteExcepcion extends RuntimeException{
    public EmpresaExistenteExcepcion(String identificador){
        super("Ya existe una empresa con el identificador "+identificador);
    }
}
