package com.cv.portfolio.model;


public class ProyectoForm {
    private String titulo;
    private String anio;
    private String categoria;
    private String estado;
    private String descripcion;

    public ProyectoForm() {
    }

    // true si los cinco campos están vacíos (fila que el usuario no ha rellenado)
    public boolean estaVacio() {
        return enBlanco(titulo) && enBlanco(anio) && enBlanco(categoria)
                && enBlanco(estado) && enBlanco(descripcion);
    }

    private boolean enBlanco(String texto) {
        return texto == null || texto.isBlank();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}