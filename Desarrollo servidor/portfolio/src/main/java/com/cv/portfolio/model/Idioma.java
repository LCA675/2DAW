package com.cv.portfolio.model;

import java.util.List;

public class Idioma {
    private String nombre;
    private String nivel;

    public Idioma(String nivel, String nombre) {
        this.nombre = nombre;
        // Si el nivel no es válido se pone medio
        this.nivel = List.of("bajo", "medio", "alto").contains(nivel) ? nivel : "medio";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
