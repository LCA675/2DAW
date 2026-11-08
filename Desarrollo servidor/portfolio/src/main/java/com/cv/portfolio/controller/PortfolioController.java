package com.cv.portfolio.controller;

import com.cv.portfolio.model.Proyecto;
import com.cv.portfolio.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PortfolioController {
    private final ProyectoService proyectoService;

    //creamos un objeto proyectoservice y hacemos su constructor
    //inyeccion de dependencias
    public PortfolioController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    //El requestparam es para indicar que no son obligatorios, asi no da error cuando se filtra sin filtros
    @GetMapping("/portfolio")
    public String mostrarPortfolio(Model model, @RequestParam(required = false) String categoria, @RequestParam(required = false) String anio) {
        Integer annio = null;
        boolean anio_Invalido = false;

        if (anio != null && !anio.isEmpty()) {
            //si el año no es válido, se queda en null y no se filtra por año
            try {
                annio = Integer.parseInt(anio.trim());
            } catch (NumberFormatException e) {
                // El texto no es un número: se avisa y no se filtra por año
                anio_Invalido = true;
            }
        }
        List<Proyecto> todos = proyectoService.obtenerProyectos();
        List<Proyecto> filtrados = proyectoService.filtrarProyectos(todos, categoria, annio);

        // Si no llega categoría, el selector muestra "Todas"
        String categoriaSeleccionada = (categoria == null) ? "Todas" : categoria;

        model.addAttribute("proyectos", filtrados);
        model.addAttribute("total", filtrados.size());
        model.addAttribute("categoria", categoriaSeleccionada);
        model.addAttribute("anio", anio);
        model.addAttribute("anioInvalido", anio_Invalido);
        model.addAttribute("categorias", List.of("Todas", "Aplicaciones", "Sitios web", "Diseño"));

        return "portfolio";
    }

}
