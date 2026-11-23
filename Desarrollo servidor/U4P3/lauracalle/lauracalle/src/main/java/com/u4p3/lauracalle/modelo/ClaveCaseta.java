package com.u4p3.lauracalle.modelo;

import java.io.Serializable;
import java.util.Objects;

//He creado esta clase para solucionar mi problema al tener 2 campos como clave primaria en la tabla de la base de datos
public class ClaveCaseta implements Serializable {

    private String calle;
    private Integer numeroCalle;

    public ClaveCaseta() {
    }

    public ClaveCaseta(String calle, Integer numeroCalle) {
        this.calle = calle;
        this.numeroCalle = numeroCalle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClaveCaseta that = (ClaveCaseta) o;
        return Objects.equals(calle, that.calle) && Objects.equals(numeroCalle, that.numeroCalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, numeroCalle);
    }
}
