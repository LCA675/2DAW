package com.cv.portfolio.controller;

import com.cv.portfolio.model.Proyecto;
import com.cv.portfolio.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
public class PortfolioController {

    private final ProyectoService proyectoService;

    public PortfolioController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // Muestra los proyectos filtrados por categoría y año (los dos filtros son opcionales)
    @GetMapping("/portfolio")
    public String mostrarPortfolio(@RequestParam(required = false) String categoria,
                                   @RequestParam(required = false) String anio,
                                   Locale locale, Model model) {
        Integer anioNumero = null;
        boolean anioInvalido = false;

        // Si el año no es un número se avisa y no se filtra por año
        if (anio != null && !anio.isBlank()) {
            try {
                anioNumero = Integer.parseInt(anio.trim());
            } catch (NumberFormatException e) {
                anioInvalido = true;
            }
        }

        List<Proyecto> proyectos = proyectoService.filtrarProyectos(
                proyectoService.obtenerProyectos(locale), categoria, anioNumero);

        model.addAttribute("proyectos", proyectos);
        model.addAttribute("total", proyectos.size());
        model.addAttribute("categoria", categoria);
        model.addAttribute("anio", anio);
        model.addAttribute("anioInvalido", anioInvalido);
        return "portfolio";
    }
}
