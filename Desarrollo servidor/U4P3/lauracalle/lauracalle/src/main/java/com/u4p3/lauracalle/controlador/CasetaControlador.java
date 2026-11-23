package com.u4p3.lauracalle.controlador;

import com.u4p3.lauracalle.dto.NuevaCasetaFormulario;
import com.u4p3.lauracalle.modelo.Caseta;
import com.u4p3.lauracalle.servicio.CasetaDuplicadaException;
import com.u4p3.lauracalle.servicio.CasetaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CasetaControlador {

    private static final List<String> CALLES = List.of(
            "Antonio Bienvenida", "Pascual Márquez", "Juan Belmonte", "Joselito el Gallo",
            "Rafael el Gallo", "Gitanillo de Triana", "Costillares",
            "Pepe Luis Vázquez", "Manolo Vázquez", "Curro Romero",
            "Ignacio Sánchez Mejías", "Bombita", "Chicuelo", "Pepe Hillo", "Espartero");

    private final CasetaService casetaService;

    public CasetaControlador(CasetaService casetaService) {
        this.casetaService = casetaService;
    }

    @GetMapping("/")
    public String mostrarRecinto(
            @RequestParam(name = "registrado", defaultValue = "false") boolean registrado, Model model) {
        if (registrado) {
            model.addAttribute("mensajeExito", "Caseta añadida al recinto. ¡Ole!");
        }
        prepararPagina(model, new NuevaCasetaFormulario());
        return "recintoFerial";
    }

    @PostMapping("/casetas")
    public String registrarCaseta(
            @Valid @ModelAttribute("nuevaCaseta") NuevaCasetaFormulario formulario,
            BindingResult resultado,
            Model model) {

        if (resultado.hasErrors()) {
            // Al volver a pintar la página hay que cargar otra vez todos los datos
            // que necesita la vista; no basta con conservar solo los campos del formulario.
            prepararPagina(model, formulario);
            return "recintoFerial";
        }

        try {
            casetaService.registrar(
                    formulario.getCalle(),
                    formulario.getNumeroCalle(),
                    formulario.getNumSocios(),
                    formulario.getNombre(),
                    formulario.getDescripcion(),
                    formulario.getFoto(),
                    formulario.getMetrosCuadrados(),
                    formulario.getFechaAlta(),
                    formulario.isPublica());
        } catch (CasetaDuplicadaException e) {
            resultado.rejectValue("numeroCalle", "duplicada", e.getMessage());
            prepararPagina(model, formulario);
            return "recintoFerial";
        }

        // POST/Redirect/GET evita repetir el alta; el aviso viaja en la URL,
        // sin necesitar una sesión HTTP para un mensaje de una sola página.
        return "redirect:/?registrado=true";
    }

    private void prepararPagina(Model model, NuevaCasetaFormulario formulario) {
        List<Caseta> casetas = casetaService.obtenerTodos();
        model.addAttribute("casetas", casetas);
        model.addAttribute("nuevaCaseta", formulario);
        model.addAttribute("calles", CALLES);
    }
}
