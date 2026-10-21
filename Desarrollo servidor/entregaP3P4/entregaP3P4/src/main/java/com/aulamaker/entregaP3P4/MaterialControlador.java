package com.aulamaker.entregaP3P4;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;

@Controller
public class MaterialControlador {

    private static final String[][] materiales = {
            {"PORTATIL", "Ordenador portatil", "Incluye cargador y una funda"},
            {"MICRO", "Kit de microcontrolador", "Incluye una placa y un cable USB"},
            {"CAMARA", "Camara de documentacion", "Incluye un soporte de mesa"}
    };

    private String[] busqueda(String codigo) {
        for (int i = 0; i < materiales.length; i++) {
            if (materiales[i][0].equals(codigo)) {
                return materiales[i];
            }
        }
        return null;
    }

    @GetMapping("/")
    public String catalogo(Model model) {
        model.addAttribute("lista", materiales);
        return "catalogo";
    }

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

    @GetMapping("/solicitud/nueva")
    public String solicitud(Model model){
        model.addAttribute("solicitud", new SolicitudPrestamoFormulario());
        model.addAttribute("materiales", materiales);
        return "formulario";
    }


}
