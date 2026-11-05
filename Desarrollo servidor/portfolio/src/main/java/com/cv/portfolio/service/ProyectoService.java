package com.cv.portfolio.service;

import com.cv.portfolio.model.Proyecto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService {

    public List<Proyecto> obtenerProyectos() {
//PROYECTO 1
//        Lista con las tecnologias para el proyecto
        List<String> list = new ArrayList<>(List.of(
                "Java 26 (JDK 26)",
                "Maven",
                "IntelliJ IDEA",
                "Patrón Factory Method",
                "Git / GitHub"
        ));

        Proyecto pr = new Proyecto("Ejercicio 3P", 2026, "Aplicaciones", "Aplicación en Java organizada con Maven que aplica el patrón Factory Method.", "Terminado",
                list, "https://github.com/LCA675/2DAW/tree/main/Desarrollo%20servidor/Ejercicio%203P", "");
//PROYECTO 2
        List<String> list1 = List.of(
                "HTML5",
                "JavaScript (vanilla)",
                "DOM y eventos",
                "Expresiones regulares",
                "Node.js 20+ (validador de ejercicios)",
                "Script .bat de Windows",
                "IntelliJ IDEA / WebStorm",
                "Git / GitHub"
        );


        Proyecto pr1 = new Proyecto("Javascript", 2026, "Sitios web", "Conjunto de páginas web interactivas creadas con HTML y JavaScript sin librerías. ", "Terminado",
                list1, "https://github.com/LCA675/2DAW/tree/main/Desarrollo%20cliente/Introduccion%20a%20JavaScript", "");


        //PROYECTO 3

        List<String> list2 = List.of(

        );

        Proyecto pr2 = new Proyecto("Diseño de interfaces", 2025, "Diseño", "Proyecto del módulo de Diseño de interfaces centrado en la composición visual y la usabilidad.", "En curso",
                list2, "https://github.com/LCA675/2DAW/tree/main/Dise%C3%B1o%20de%20interfaces", null);


        //Creamos el list con los proyectos, los añadimos y los devolvemos con el re3turn
        List<Proyecto> proyectos = new ArrayList<>();

        proyectos.add(pr);
        proyectos.add(pr1);
        proyectos.add(pr2);

        return proyectos;
    }

    public List<Proyecto> filtrarProyectos(List<Proyecto> proyectos, String categoria, Integer anni) {
        List<Proyecto> list = new ArrayList<>();


        for (int i = 0; i < proyectos.size(); i++) {
            boolean cat = false;
            boolean an = false;

            //Comprobamos si cumple las condiciones para que sea guardado
            if (anni == null || anni.equals(proyectos.get(i).getAnio())) {
                an = true;
            }

            //Comprobamos si cumple las condiciones para que sea guardado
            if (categoria == null || categoria.equalsIgnoreCase(proyectos.get(i).getCategoria()) || categoria.isEmpty()) {
                cat = true;
            }
            //Si las dos son verdaderas las guardamos en el list
            if (cat && an) {
                list.add(proyectos.get(i));
            }

        }

        return list;
    }
}
