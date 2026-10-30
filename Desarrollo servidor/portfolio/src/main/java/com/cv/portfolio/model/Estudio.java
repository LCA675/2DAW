package com.cv.portfolio.model;

public class Estudio {
    private String titulo;
    private String centro;
    private String anio_comienzo;
    private String anio_final;

    public Estudio(String anio_final, String anio_comienzo, String centro, String titulo) {
        this.anio_final = anio_final;
        this.anio_comienzo = anio_comienzo;
        this.centro = centro;
        this.titulo = titulo;
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
}
