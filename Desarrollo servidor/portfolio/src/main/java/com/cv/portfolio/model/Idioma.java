package com.cv.portfolio.model;

public class Idioma {
    private String nombre;
    private String nivel;

    public Idioma(String nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
//Si no es alto y no es bajo y no es medio entra en el if
        if (!nivel.equals("bajo") && !nivel.equals("medio") && !nivel.equals("alto") ){
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
