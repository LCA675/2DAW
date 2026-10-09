package org.example.Ejercicio2;

// figura triangulo para completar el ejercicio del factory
public class Triangulo extends Figura{


    public Triangulo(String color) {
        super(color);
    }

    // metodo propio para impirmir el triangulo
    @Override
    public void dibujarFigura() {
        System.out.println("Triangulo de color "+this.color);
    }
}
