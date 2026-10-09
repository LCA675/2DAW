package org.example.Ejercicio2;

// la clase base abstracta de las figuras para el patron factory
public abstract class Figura {
    protected String color;

    // constructor comun para guardar el color
    public Figura(String color){
        this.color = color;
    }

    // este metodo abstracto lo tiene que definir cada figura
    public abstract void dibujarFigura();
}
