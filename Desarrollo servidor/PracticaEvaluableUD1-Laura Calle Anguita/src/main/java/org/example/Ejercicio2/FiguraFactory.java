package org.example.Ejercicio2;

import java.util.Locale;

public class FiguraFactory {
    public Figura crearFIgura(String figura,String color){

        if(figura.toUpperCase()=="CIRCULO"){
            Circulo cir = new Circulo(color);
            return cir;
        }
        if(figura.toUpperCase()=="RECTANGULO"){
            Rectangulo rec = new Rectangulo(color);
            return rec;
        }
        if(figura.toUpperCase()=="TRIANGULO"){
            Triangulo tri = new Triangulo(color);
            return tri;
        }
        if(figura.toUpperCase()=="CUADRADO"){
            Cuadrado cua = new Cuadrado(color);
            return cua;
        }

        return null;
    }
}
