package org.example.Ejercicio2;

import java.util.Locale;

// esta es la factoria que crea los objetos segun el texto que le pasemos
public class FiguraFactory {

    // aqui esta el truco del patron factory, segun la cadena te devuelve un tipo de figura u otro
    public Figura crearFIgura(String figura,String color){

        // compruebo si piden circulo ignornado mayusculas y minusculas
        if(figura.equalsIgnoreCase("circulo")){
            Circulo cir = new Circulo(color);
            return cir;
        }
        if(figura.equalsIgnoreCase("rectangulo")){
            Rectangulo rec = new Rectangulo(color);
            return rec;
        }
        if(figura.equalsIgnoreCase("triangulo")){
            Triangulo tri = new Triangulo(color);
            return tri;
        }
        if(figura.equalsIgnoreCase("cuadrado")){
            Cuadrado cua = new Cuadrado(color);
            return cua;
        }

        // si no coincide con ninguna devuelve null para evitar objetos raros
        return null;
    }
}
