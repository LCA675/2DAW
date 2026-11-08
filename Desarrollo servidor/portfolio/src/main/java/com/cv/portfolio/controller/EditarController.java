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
    // Es configuración (no datos de una petición), por eso puede ser un atributo final
    private final int maxProyectos;

    // Inyección de dependencias: Spring pasa el service y el valor de portfolio.max-proyectos
    public EditarController(FormularioService formularioService,
                            @Value("${portfolio.max-proyectos}") int maxProyectos) {
        this.formularioService = formularioService;
        this.maxProyectos = maxProyectos;
    }

    // GET: primera vez que se abre la página -> formulario vacío con una fila de proyecto
    @GetMapping
    public String mostrarFormulario(Model model) {
        PortfolioForm form = new PortfolioForm();
        form.getProyectos().add(new ProyectoForm());

        prepararModelo(model, form, new LinkedHashMap<>());
        return "editar";
    }

    // POST: todos los botones envían aquí. "accion" dice qué botón se pulsó:
    // "anadir", "quitar-N" o "preview". Si no llega, se toma "preview".
    @PostMapping
    public String procesarFormulario(@ModelAttribute("form") PortfolioForm form,
                                     @RequestParam(defaultValue = "preview") String accion,
                                     Model model) {
        // Variable local: cada petición tiene sus propios errores
        Map<String, String> errores = new LinkedHashMap<>();

        // Se comprueba el máximo en CADA envío, aunque se hayan añadido filas manipulando el HTML
        if (form.getProyectos().size() > maxProyectos) {
            errores.put("proyectos", "error.maximo");
            prepararModelo(model, form, errores);
            return "editar";
        }

        if (accion.equals("preview")) {
            errores = formularioService.validar(form, maxProyectos);

            // Con errores: se vuelve al formulario conservando lo escrito
            if (!errores.isEmpty()) {
                prepararModelo(model, form, errores);
                return "editar";
            }

            // Sin errores: se quitan las filas vacías y se muestra la vista previa
            form.setProyectos(formularioService.quitarFilasVacias(form.getProyectos()));
            model.addAttribute("form", form);
            return "vista-previa";
        }

        // Botones "Añadir proyecto" o "Quitar este proyecto"
        formularioService.gestionarFilas(form, accion, maxProyectos);
        prepararModelo(model, form, errores);
        return "editar";
    }

    // Añade al modelo lo que necesita editar.html (evita repetir estas tres líneas)
    private void prepararModelo(Model model, PortfolioForm form, Map<String, String> errores) {
        model.addAttribute("form", form);
        model.addAttribute("errores", errores);
        model.addAttribute("max", maxProyectos);
    }
}