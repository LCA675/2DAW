package com.cv.portfolio.model;

public class Idioma {
    private String nombre;
    private String nivel;

    public Idioma(String nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;

        if (nivel)
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
