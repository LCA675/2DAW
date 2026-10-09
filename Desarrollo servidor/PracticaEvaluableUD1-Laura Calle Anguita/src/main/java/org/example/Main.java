package org.example;

import org.example.Ejercicio1.Casa;
import org.example.Ejercicio1.Pared;
import org.example.Ejercicio1.Tejado;
import org.example.Ejercicio2.Figura;
import org.example.Ejercicio2.FiguraFactory;
import org.example.Ejercicio3.Presidente;

import java.util.Scanner;

// clase principal para probar todo lo que hemos hecho en los ejercicios
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void main() {


        int opcion = 20;

        // este menu lo he puesto para ir probando cada patron de diseño segun la opcion que ponga el usuario
        while (opcion > 0) {
            System.out.println("Ejercicio 1: Patrón DI");
            System.out.println("Ejercicio 2: Patrón Factory");
            System.out.println("Ejercicio 3: Patrón Singleton");
            System.out.println("Opcion 0 Para salir");
            System.out.println("Introduzca una opcion");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // probando inyeccion de dependencias, le paso los objetos que e creado fuera a la casa
                    Tejado tejado = new Tejado(){};
                    Pared[] paredes = new Pared[]{};
                    Pared pared1 = new Pared(2.10);
                    Pared pared2 = new Pared(2.10);
                    Pared pared3 = new Pared(2.10);
                    Pared pared4 = new Pared(2.10);

                    // le inyectamos el tejado y las paredes al crear la casa 
                    Casa casa1 = new Casa(120,tejado,paredes);

                    System.out.println("Area casa: "+casa1.getArea());
                    System.out.println("");
                    break;
                case 2:

                    // probando el patron factory (factoria) para no usar el new de cada figura
                    FiguraFactory factory = new FiguraFactory();
                    Figura triangulo = factory.crearFIgura("triangulo", "rojo");
                    Figura circulo = factory.crearFIgura("circulo", "azuk");
                    Figura cuadrado = factory.crearFIgura("cuadrado", "verde");
                    Figura rectangulo = factory.crearFIgura("rectangulo", "rojo");

                    // comprobación de si dibuja bien cada figura con su color 
                    triangulo.dibujarFigura();
                    circulo.dibujarFigura();
                    cuadrado.dibujarFigura();
                    rectangulo.dibujarFigura();
                    System.out.println("");

                    break;
                case 3:
                    // probando singleton, aqui deberia darnos el mismo presidente en las dos variables
                    Presidente pres1 = Presidente.instancia();
                    Presidente pres2 = Presidente.instancia();

                    pres1.setNombre("Pedro");
                    pres1.setApellidos("Sanchez");
                    pres1.setAnioEleccion(2018);

                    // compruebo si apuntan a la misma instancia en memoria con ==
                    if (pres1 == pres2){
                        System.out.println("Solo existe una instancia");
                    } else {
                        System.out.println("Existen 2 instancias diferentes");
                    }
                    break;

            }

        }


    }

}
