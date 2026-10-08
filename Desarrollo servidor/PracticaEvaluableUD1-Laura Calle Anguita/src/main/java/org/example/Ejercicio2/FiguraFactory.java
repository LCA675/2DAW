package org.example.Ejercicio2;

import java.util.Locale;

public class FiguraFactory {

    public Figura crearFIgura(String figura,String color){

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

        return null;
    }
}
