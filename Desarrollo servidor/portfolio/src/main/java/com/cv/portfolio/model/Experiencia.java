package com.cv.portfolio.model;

public class Experiencia {
    private String puesto;
    private String empresa;
    private String anio_comienzo;
    private String anio_final;

    public Experiencia(String puesto, String empresa, String anio_comienzo, String anio_final) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.anio_comienzo = anio_comienzo;
        this.anio_final = anio_final;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
