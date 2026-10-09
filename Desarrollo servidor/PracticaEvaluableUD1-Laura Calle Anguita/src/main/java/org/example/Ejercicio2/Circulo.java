package org.example.Ejercicio2;

// circulo hereda de figura
public class Circulo extends Figura{
    // llamamos al constructor del padre con super para el color
    public Circulo(String color) {
        super(color);
    }

    // implementacion del metodo para pintar el circulo
    @Override
    public void dibujarFigura() {
        System.out.println("Circulo de color "+this.color);
    }
}
