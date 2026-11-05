package com.cv.portfolio.model;

public class Habilidad {
    private String nombre;
    private String descripcion;
    private String nivel;

    public Habilidad(String nombre, String descripcion, String nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
//Si no es alto y no es bajo y no es medio entra en el if
        if (!nivel.equals("bajo") && !nivel.equals("medio") && !nivel.equals("alto")) {
            System.out.println("Valor incorrecto, añadiendo nivel medio");
            this.nivel = "medio";
        }
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
