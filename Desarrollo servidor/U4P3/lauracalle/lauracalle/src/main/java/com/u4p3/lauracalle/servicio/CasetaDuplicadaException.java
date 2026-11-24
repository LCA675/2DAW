package com.u4p3.lauracalle.servicio;


//Excepcion que he creado para controlar que no se añaden casetas con la misma calle y elmismo numero
public class CasetaDuplicadaException extends RuntimeException {

    public CasetaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}