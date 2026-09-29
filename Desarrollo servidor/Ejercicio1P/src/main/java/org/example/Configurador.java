package org.example;

public class Configurador {
    private static final Configurador INSTANCIA = new Configurador();

    private String configuracion;

    private Configurador() {
    }

    public static Configurador obtenerInstancia() {
        return INSTANCIA;
    }

    public void registrarConfiguracion(String config) {
        this.configuracion = config;
    }

    public String obtenerConfiguracion() {
        return configuracion;
    }

}
