package org.example.Ejercicio1;

// clase pared que sirve como dependencia para la casa
public class Pared {
    protected double altura;

    // constructor con la altura de la pared
    public Pared(double altura) {
        this.altura = altura;
    }

    // constructor vacio 
    public Pared() {
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
