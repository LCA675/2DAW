package org.example;

import org.example.Ejercicio1.Pared;
import org.example.Ejercicio1.Tejado;

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
            switch (opcion) {
                opcion = sc.next("Introduzca la opcion");
                case 1:
                    Tejado tejado = new Tejado(){};
                    Pared[] paredes = new Pared[]{};
                    Pared pared1 =
                    break;
                case 2:
                    break;
                case 3:
                    break;

            }

        }


    }

}
