package org.example.Ejercicio2;

public class Rectangulo extends Figura{

    public Rectangulo(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Rectangulo de color "+this.color);
    }
}
