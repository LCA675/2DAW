package com.cv.portfolio.controller;

import com.cv.portfolio.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
    private final ProyectoService proyectoService;
//creamos un objeto proyectoservice y hacemos su constructor
    //inyeccion de dependencias
    public PortfolioController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model, String categoria, String anio){
        @RequestParam
    }

}
