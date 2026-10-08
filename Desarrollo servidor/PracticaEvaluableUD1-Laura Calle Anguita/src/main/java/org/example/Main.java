package org.example;

import org.example.Ejercicio1.Casa;
import org.example.Ejercicio1.Pared;
import org.example.Ejercicio1.Tejado;
import org.example.Ejercicio2.Figura;
import org.example.Ejercicio2.FiguraFactory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void main() {


        int opcion = 20;

        while (opcion > 0) {
            System.out.println("Ejercicio 1: Patrón DI");
            System.out.println("Ejercicio 2: Patrón Factory");
            System.out.println("Ejercicio 3: Patrón Singleton");
            System.out.println("Opcion 0 Para salir");
            System.out.println("Introduzca una opcion");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Tejado tejado = new Tejado(){};
                    Pared[] paredes = new Pared[]{};
                    Pared pared1 = new Pared(2.10);
                    Pared pared2 = new Pared(2.10);
                    Pared pared3 = new Pared(2.10);
                    Pared pared4 = new Pared(2.10);

                    Casa casa1 = new Casa(120,tejado,paredes);

                    System.out.println("Area casa: "+casa1.getArea());
                    System.out.println("");
                    break;
                case 2:

                    FiguraFactory factory = new FiguraFactory();
                    Figura triangulo = factory.crearFIgura("triangulo", "rojo");
                    Figura circulo = factory.crearFIgura("circulo", "azuk");
                    Figura cuadrado = factory.crearFIgura("cuadrado", "verde");
                    Figura rectangulo = factory.crearFIgura("rectangulo", "rojo");

                    triangulo.dibujarFigura();
                    circulo.dibujarFigura();
                    cuadrado.dibujarFigura();
                    rectangulo.dibujarFigura();
                    System.out.println("");

                    break;
                case 3:
                    break;

            }

        }


    }

}
