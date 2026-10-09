package org.example.Ejercicio2;

// subclase cuadrado que tambien hereda de figura
public class Cuadrado extends Figura{
    public Cuadrado(String color) {
        super(color);
    }

    // imprimo por pantalla lo que vale la figura
    @Override
    public void dibujarFigura() {
        System.out.println("Cuadrado de color "+this.color);
    }
}
