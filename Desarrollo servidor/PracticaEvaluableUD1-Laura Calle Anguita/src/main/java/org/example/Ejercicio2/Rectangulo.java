package org.example.Ejercicio2;

// otra figura concreta que puede crear la factoria
public class Rectangulo extends Figura{

    public Rectangulo(String color) {
        super(color);
    }

    // aqui se dibuja el rectangulo mostrando el color que se ha pasado
    @Override
    public void dibujarFigura() {
        System.out.println("Rectangulo de color "+this.color);
    }
}
