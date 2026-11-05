package com.cv.portfolio.model;

public class Estudio {
    private String titulo;
    private String centro;
    private String anio_comienzo;
    private String anio_final;
    private boolean enCurso;

    public Estudio(String titulo, String centro, String anio_comienzo, String anio_final, boolean enCurso) {
        this.titulo = titulo;
        this.centro = centro;
        this.anio_comienzo = anio_comienzo;
        this.anio_final = anio_final;
        this.enCurso = enCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getAnio_comienzo() {
        return anio_comienzo;
    }

    public void setAnio_comienzo(String anio_comienzo) {
        this.anio_comienzo = anio_comienzo;
    }

    public String getAnio_final() {
        return anio_final;
    }

    public void setAnio_final(String anio_final) {
        this.anio_final = anio_final;
    }

    public boolean isEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }
}
