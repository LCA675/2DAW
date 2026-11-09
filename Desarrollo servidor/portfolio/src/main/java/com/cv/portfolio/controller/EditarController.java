package com.cv.portfolio.controller;

import com.cv.portfolio.model.PortfolioForm;
import com.cv.portfolio.model.ProyectoForm;
import com.cv.portfolio.service.FormularioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/portfolio/editar")
public class EditarController {

    private final FormularioService formularioService;
    private final int maxProyectos;

    // Lee el máximo de proyectos de application.properties
    public EditarController(FormularioService formularioService,
                            @Value("${portfolio.max-proyectos}") int maxProyectos) {
        this.formularioService = formularioService;
        this.maxProyectos = maxProyectos;
    }

    // Muestra el formulario vacío con una fila de proyecto
    @GetMapping
    public String mostrarFormulario(Model model) {
        PortfolioForm form = new PortfolioForm();
        form.getProyectos().add(new ProyectoForm());
        return mostrarEditar(model, form, new LinkedHashMap<>());
    }

    // Todos los botones envían aquí; "accion" dice cuál se ha pulsado (anadir, quitar-N o preview)
    @PostMapping
    public String procesarFormulario(@ModelAttribute("form") PortfolioForm form,
                                     @RequestParam(defaultValue = "preview") String accion,
                                     Model model) {
        // No se permiten más proyectos del máximo, aunque se modifique el HTML
        if (form.getProyectos().size() > maxProyectos) {
            return mostrarEditar(model, form, Map.of("proyectos", "error.maximo"));
        }

        // Botones de añadir o quitar proyecto
        if (!accion.equals("preview")) {
            formularioService.gestionarFilas(form, accion, maxProyectos);
            return mostrarEditar(model, form, new LinkedHashMap<>());
        }

        // Si hay errores se vuelve al formulario con lo que se había escrito
        Map<String, String> errores = formularioService.validar(form);
        if (!errores.isEmpty()) {
            return mostrarEditar(model, form, errores);
        }

        // Sin errores se muestra la vista previa sin las filas vacías
        formularioService.quitarFilasVacias(form);
        model.addAttribute("form", form);
        return "vista-previa";
    }

    // Añade al modelo lo que necesita editar.html
    private String mostrarEditar(Model model, PortfolioForm form, Map<String, String> errores) {
        model.addAttribute("form", form);
        model.addAttribute("errores", errores);
        model.addAttribute("max", maxProyectos);
        return "editar";
    }
}
