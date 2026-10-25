package com.entregaP5P6.entregaP5P6;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CentroController {
    //Declaramos un array con las actividades
    private static final String[] actividades = {"actividad1", "actividad2", "actividad3"};
//Hacemos el mapping de inicio
    @GetMapping("/")
    public String inicio(Model model){

        model.addAttribute("nombre", actividades);
        model.addAttribute("ruta", "/");

        return "inicio";
    }
//Hacemos el mapping de visita
    @GetMapping("/visita")
    public String visita(Model model){
        model.addAttribute("ruta", "/visita");
        return "visita";
    }




}
