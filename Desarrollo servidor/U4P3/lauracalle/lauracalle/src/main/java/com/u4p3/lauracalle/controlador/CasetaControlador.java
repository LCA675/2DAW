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

    //Listado de todas las calles del recinto que existen
    private static final List<String> CALLES = List.of(
            "Antonio Bienvenida", "Pascual Márquez", "Juan Belmonte", "Joselito el Gallo",
            "Rafael el Gallo", "Gitanillo de Triana", "Costillares",
            "Pepe Luis Vázquez", "Manolo Vázquez", "Curro Romero",
            "Ignacio Sánchez Mejías", "Bombita", "Chicuelo", "Pepe Hillo", "Espartero");

    private final CasetaService casetaService;

    public CasetaControlador(CasetaService casetaService) {
        this.casetaService = casetaService;
    }

    //Mapping para mostrar la pagina principal donde tenemos un mensaje cuando se añade una caseta con existe
//    despues prepara los datos de la pagina con un formulario vacio y mostrara la plantilla de recintoFerial.html
    @GetMapping("/")
    public String mostrarRecinto(
            @RequestParam(name = "registrado", defaultValue = "false") boolean registrado, Model model) {
        if (registrado) {
            model.addAttribute("mensajeExito", "Caseta añadida al recinto. ¡Ole!");
        }
        prepararPagina(model, new NuevaCasetaFormulario());
        return "recintoFerial";
    }
//el postmapping recibira los datos que se han enviado del formulario y los validara(@valid)

    @PostMapping("/casetas")
    public String registrarCaseta(
            @Valid @ModelAttribute("nuevaCaseta") NuevaCasetaFormulario formulario,
            BindingResult resultado,
            Model model) {

        //Si hay errores vuelve a mostrar la pagina con los errores y con los datos que habia escrito el usuairo
        if (resultado.hasErrors()) {
            prepararPagina(model, formulario);
            return "recintoFerial";
        }
        //Hacemos un try catch para ver si la caseta que esta escribiendo ya existe, en caso de que exista, salta la excepcion que he creado CasetaDuplicadaException

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
            // vuelve a mostrar la pagina con los errores y con los datos que habia escrito el usuairo
            resultado.rejectValue("numeroCalle", "duplicada", e.getMessage());
            prepararPagina(model, formulario);
            return "recintoFerial";
        }
        //Devolvera esto que al devolverse se ejecutar el mostrarRecinto con el mensaje de exito
        return "redirect:/?registrado=true";
    }
//Metodo auxiliar
    private void prepararPagina(Model model, NuevaCasetaFormulario formulario) {
        List<Caseta> casetas = casetaService.obtenerTodos();
        model.addAttribute("casetas", casetas);
        model.addAttribute("nuevaCaseta", formulario);
        model.addAttribute("calles", CALLES);
    }
}
