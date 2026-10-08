package org.example.Ejercicio2;

public class Cuadrado extends Figura{
    public Cuadrado(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Cuadrado de color "+this.color);
    }
}
