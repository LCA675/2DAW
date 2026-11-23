package com.u4p3.lauracalle.servicio;

// Excepción de negocio: se lanza al intentar registrar una caseta cuya calle y número ya existen.
// Hereda de RuntimeException para no obligar a declarar throws en cada capa.
public class CasetaDuplicadaException extends RuntimeException {

    public CasetaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}