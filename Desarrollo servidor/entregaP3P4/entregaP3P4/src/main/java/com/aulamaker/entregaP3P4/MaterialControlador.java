package com.aulamaker.entregaP3P4;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//@Controller declaramos que va a  recibir las peticiones del navegador
@Controller
public class MaterialControlador {
//  Lista de materiales guardado en un array con codigo, nombre y descripcion
    private static final String[][] materiales = {
            {"PORTATIL", "Ordenador portatil", "Incluye cargador y una funda"},
            {"MICRO", "Kit de microcontrolador", "Incluye una placa y un cable USB"},
            {"CAMARA", "Camara de documentacion", "Incluye un soporte de mesa"}
    };
//este metodo nos sirve para buscar materiales por su codigo
    private String[] busqueda(String codigo) {
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i][0].equals(codigo)) {
                return materiales[i];
            }
        }
        return null;
    }
//CUenta los dias de recogida y devolucion y le sumamos 1, devolvemos un long para poder multiplicarlo por las unidades
    private long calcularDias(LocalDate fechaRecog, LocalDate fechaDevo) {
        return ChronoUnit.DAYS.between(fechaRecog, fechaDevo) + 1;
    }
//Manda a la pagina principal
    @GetMapping("/")
    public String catalogo(Model model) {
        model.addAttribute("lista", materiales);
        return "catalogo";
    }
//Ficha del material
    @GetMapping("/materiales/{codigo}")
    public String ficha(@PathVariable String codigo,
                        @RequestParam(required = false, defaultValue = "general") String turno,
                        Model model) {

        String[] material = busqueda(codigo);

        if (material == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("codigo", material[0]);
        model.addAttribute("nombre", material[1]);
        model.addAttribute("descripcion", material[2]);
        model.addAttribute("turno", turno);

        return "ficha";

    }
//Va a mostrar el formulario vacio ya que hace falta un dto vacio para poder enlazar los campos
    @GetMapping("/solicitud/nueva")
    public String solicitud(Model model) {
        model.addAttribute("solicitud", new SolicitudPrestamoFormulario());
        model.addAttribute("materiales", materiales);
        return "formulario";
    }

    @Valid
    @PostMapping("/solicitudes")
    public String comprobarForm(@Valid @ModelAttribute("solicitud")
                                SolicitudPrestamoFormulario form,
                                BindingResult result, Model model) {

//Condicion 1: si el campo no se ha enviado vale null, tenemos que comprobar que no este nulo
//Condicion2: si tiene algo escrito, comprobamos si no hay solo espacios
//Condicion 3: comprobamos si se encuentra en el catalogo,llamamos al metodo busqueda con el codigo que se ha enviado desde el formulario

        if (form.getMaterial() != null && !form.getMaterial().isBlank()
                && busqueda(form.getMaterial()) == null) {
            //si se cumplen estas 3 opciones añade un error al bindingresult

            result.rejectValue("material", "material.invalido", "El material seleccionado no existe");
        }
//Si la fecha de recogida y devolucion existen se comprueba dentro si la fecha de devolucion es anterior a la de la recogida
//Si la fecha es anterior daremos un error en fecha de devolucion
        if (form.getFechaRecog() != null && form.getFechaDevo() != null) {
            if (form.getFechaDevo().isBefore(form.getFechaRecog())) {
                result.rejectValue("fechaDevo", "fechaDevo.invalido", "La fecha de devolucion es incorrecta");
            }
        }
//Si enconctramos algun error volvemos al formulario
        if (result.hasErrors()) {
            model.addAttribute("materiales", materiales);
            return "formulario";
        }
//Aqui la solicituda va a ser valida y tenemos variables locales para poder realizar los calculos
        String[] material = busqueda(form.getMaterial());
        long dias = calcularDias(form.getFechaRecog(), form.getFechaDevo());
        long diasUnidades = dias*form.getUnidades();

        model.addAttribute("solicitud", form);
        model.addAttribute("material", material[1]);
        model.addAttribute("dias", dias);
        model.addAttribute("diasUnidad", diasUnidades);



        return "resultado";



    }


}
