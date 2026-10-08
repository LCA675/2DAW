package org.example.Ejercicio2;

public class Circulo extends Figura{
    public Circulo(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Circulo de color "+this.color);
    }
}
