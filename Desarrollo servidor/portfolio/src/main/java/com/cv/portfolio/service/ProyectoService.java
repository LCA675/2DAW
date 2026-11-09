package com.cv.portfolio.service;

import com.cv.portfolio.model.Proyecto;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProyectoService {

    // Lee los textos traducidos de los ficheros messages
    private final MessageSource mensajes;

    public ProyectoService(MessageSource mensajes) {
        this.mensajes = mensajes;
    }

    // Devuelve mis proyectos en el idioma elegido
    // La categoría y el estado van en español porque se usan para filtrar
    public List<Proyecto> obtenerProyectos(Locale locale) {
        Proyecto ejercicio3p = new Proyecto("Ejercicio 3P", 2026, "Aplicaciones",
                t("datos.pr1.desc", locale), "Terminado",
                List.of("Java 26 (JDK 26)", "Maven", "IntelliJ IDEA",
                        t("datos.pr1.tec.patron", locale), "Git / GitHub"),
                "https://github.com/LCA675/2DAW/tree/main/Desarrollo%20servidor/Ejercicio%203P",
                "/img/java.png");

        Proyecto javascript = new Proyecto("Javascript", 2026, "Sitios web",
                t("datos.pr2.desc", locale), "Terminado",
                List.of("HTML5", "JavaScript (vanilla)",
                        t("datos.pr2.tec.dom", locale), t("datos.pr2.tec.regex", locale),
                        t("datos.pr2.tec.node", locale), t("datos.pr2.tec.bat", locale),
                        "IntelliJ IDEA / WebStorm", "Git / GitHub"),
                "https://github.com/LCA675/2DAW/tree/main/Desarrollo%20cliente/Introduccion%20a%20JavaScript",
                "/img/js.jpg");

        Proyecto interfaces = new Proyecto(t("datos.pr3.titulo", locale), 2025, "Diseño",
                t("datos.pr3.desc", locale), "En curso",
                List.of(),
                "https://github.com/LCA675/2DAW/tree/main/Dise%C3%B1o%20de%20interfaces",
                null);

        return List.of(ejercicio3p, javascript, interfaces);
    }

    // Devuelve los proyectos que cumplen los filtros (null o vacío = sin filtro)
    public List<Proyecto> filtrarProyectos(List<Proyecto> proyectos, String categoria, Integer anio) {
        boolean todasCategorias = categoria == null || categoria.isEmpty() || categoria.equalsIgnoreCase("Todas");
        List<Proyecto> filtrados = new ArrayList<>();

        for (Proyecto proyecto : proyectos) {
            boolean cumpleCategoria = todasCategorias || categoria.equalsIgnoreCase(proyecto.getCategoria());
            boolean cumpleAnio = anio == null || anio == proyecto.getAnio();
            if (cumpleCategoria && cumpleAnio) {
                filtrados.add(proyecto);
            }
        }
        return filtrados;
    }

    // Devuelve el texto de la clave en el idioma elegido
    private String t(String clave, Locale locale) {
        return mensajes.getMessage(clave, null, locale);
    }
}
