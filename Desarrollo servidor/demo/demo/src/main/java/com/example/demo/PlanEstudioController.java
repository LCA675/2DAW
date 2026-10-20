package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

// Indica a Spring Boot que esta clase gestiona las peticiones web
@Controller
public class PlanEstudioController {

    // Método que atiende la petición GET a la ruta raíz "/"
    @GetMapping("/")
    public String mostrarPlan(
            @RequestParam(defaultValue = "estudiante") String nombre,
            Model model) {

        // Lista de asignaturas previstas para el día (cadenas de texto simples)
        List<String> asignaturas = Arrays.asList(
                "Desarrollo web en entorno cliente",
                "Desarrollo web en entorno servidor",
                "Diseño de interfaces web"
        );

        // Duración en minutos correspondiente a cada asignatura (mismo orden)
        List<Integer> duraciones = Arrays.asList(55, 50, 45);

        // Enviar datos a la plantilla Thymeleaf a través del modelo
        model.addAttribute("nombre", nombre);
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("duraciones", duraciones);

        // Devuelve el nombre de la plantilla sin extensión: plan.html
        return "plan";
    }
}
