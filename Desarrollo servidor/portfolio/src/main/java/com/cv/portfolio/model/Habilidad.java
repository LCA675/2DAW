package com.cv.portfolio.model;

import java.util.List;

public class Habilidad {
    private String nombre;
    private String descripcion;
    private String nivel;

    public Habilidad(String nombre, String descripcion, String nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        // Si el nivel no es válido se pone medio
        this.nivel = List.of("bajo", "medio", "alto").contains(nivel) ? nivel : "medio";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
