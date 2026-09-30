package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        LibroDAO libroDAO = new LibroDAOImpl();

        Libro libro1 = new Libro(1, 1967, "Cien años de soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro(2, 1605, "Don Quijote de la Mancha", " Miguel de Cervantes");

        libroDAO.agregar(libro1);
        libroDAO.agregar(libro2);

        int opcion = 0;

        while (opcion >= 0) {
            System.out.println("1 - Para obtener una lista de todos los libros.");
            System.out.println("2 - Para obtener un libro por su ID.");
            System.out.println("3 - Para agregar un nuevo libro.");
            System.out.println("4 - Para actualizar un libro existente.");
            System.out.println("5 - Para eliminar un libro por su ID.");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Todos los libros :");
                    System.out.println(libroDAO.obtenerTodos());
                    ;
                    break;
                case 2:
                    System.out.println("Introduzca el id a buscar");
                    int id = sc.nextInt();
                    System.out.println(libroDAO.obtenerPorID(id));
                    ;
                    break;
                case 3:
                    System.out.println("Introduzca el id del nuevo libro");
                    int id1 = sc.nextInt();
                    System.out.println("Introduzca el titulo del nuevo libro");
                    String titulo = sc.next();
                    System.out.println("Introduzca el autor del nuevo libro");
                    String autor = sc.next();
                    System.out.println("Introduzca el año de publicacion del nuevo libro");
                    int anioPublicacion = sc.nextInt();

                    Libro lib = new Libro(id1, anioPublicacion, titulo, autor);

                    libroDAO.agregar(lib);

                    break;
                case 4:
                    System.out.println("Introduzca el id del  libro");
                    id1 = sc.nextInt();

                    if (libroDAO.obtenerPorID(id1)!=null){
                        System.out.println("Introduzca el titulo del  libro");
                        titulo = sc.next();
                        System.out.println("Introduzca el autor del  libro");
                        autor = sc.next();
                        System.out.println("Introduzca el año de publicacion del  libro");
                        anioPublicacion = sc.nextInt();

                        Libro lib1 = new Libro(id1, anioPublicacion, titulo, autor);

                        libroDAO.actualizar(lib1);
                    }

                    if (libroDAO.obtenerPorID(id1)==null){
                        System.out.println("No existe un libro con ese ID");
                    }


                    break;
                case 5:
                    System.out.println("Introduzca el id a eliminar");
                    id = sc.nextInt();

                    if (libroDAO.obtenerPorID(id)!=null){
                        libroDAO.eliminar(id);
                    }

                    if (libroDAO.obtenerPorID(id)==null){
                        System.out.println("No existe un libro con ese ID");
                    }

                    break;


            }
        }


    }
}