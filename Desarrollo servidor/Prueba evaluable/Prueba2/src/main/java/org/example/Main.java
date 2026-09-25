package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Consulta consulta = new Consulta();

        int opcion = 1;
       do{
           opcion = sc.nextInt();
           switch (opcion) {

               case 1:
                   System.out.println("Registros con excusa con perro o gato y retraso entre 2 y 6 dias:");
                   String resultado = consulta.alumno_mayor_drama();
                   System.out.println(resultado);
                   break;

               case 2:
                   System.out.println("Muestra las excusas que cumplan simultáneamente estas condiciones:\n" +
                           "\n" +
                           "La excusa contiene la palabra perro o la palabra gato.\n" +
                           "El número de días de retraso está entre 2 y 6, ambos incluidos.\n" +
                           "Ordena los resultados de mayor a menor número de días de retraso.");
                   resultado = consulta.excusa_animal();
                   System.out.println(resultado);
                   break;

               case 3:
                   System.out.println("Muestra los registros que todavía no tengan fecha de entrega y que, además, cumplan una de estas condiciones:\n" +
                           "\n" +
                           "La credibilidad sea inferior a 4.\n" +
                           "El nivel de drama sea igual o superior a 9.");
                   resultado = consulta.registros_sin_fecha();
                   System.out.println(resultado);
                   break;

               case 4:
                   System.out.println("Muestra los registros que cumplan alguna de las siguientes condiciones:\n" +
                           "\n" +
                           "Tengan un nivel de drama igual o superior a 8 y una credibilidad menor o igual que 3.\n" +
                           "Tengan entre 2 y 5 días de retraso y la excusa contenga la palabra perro.");
                   resultado = consulta.registros_avamzados();
                   System.out.println(resultado);

               default:
                   System.out.println("Opción no válida.");
                   break;
           }
       } while( opcion>0);
    }
}