package com.cv.portfolio.controller;

import com.cv.portfolio.model.Estudio;
import com.cv.portfolio.model.Experiencia;
import com.cv.portfolio.model.Habilidad;
import com.cv.portfolio.model.Idioma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class CVController {

    // Nombre guardado en application.properties
    @Value("${cv.nombre}")
    private String nombre;

    // Lee los textos traducidos de los ficheros messages
    private final MessageSource mensajes;

    public CVController(MessageSource mensajes) {
        this.mensajes = mensajes;
    }

    // La raíz de la web lleva al currículum
    @GetMapping("/")
    public String inicio() {
        return "redirect:/curriculum";
    }

    // Muestra el currículum en el idioma elegido
    @GetMapping("/curriculum")
    public String mostrarCV(Model model, Locale locale) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("titular", t("datos.titular", locale));
        model.addAttribute("correo", "example@gmail.com");
        model.addAttribute("presentacion", t("datos.presentacion", locale));

        model.addAttribute("estudios", new Estudio[]{
                new Estudio(t("datos.estudio1", locale), "IES Ramon del valle Inclan", "2023", "2025", false),
                new Estudio(t("datos.estudio2", locale), "IES Velazquez", "2025", "", true)
        });

        model.addAttribute("experiencias", new Experiencia[]{
                new Experiencia(t("datos.exp1.puesto", locale), "NTTDATA", t("datos.exp1.inicio", locale), t("datos.exp1.fin", locale))
        });

        model.addAttribute("habilidades", new Habilidad[]{
                new Habilidad(t("datos.hab1.nombre", locale), t("datos.hab1.desc", locale), "medio"),
                new Habilidad(t("datos.hab2.nombre", locale), t("datos.hab2.desc", locale), "medio"),
                new Habilidad(t("datos.hab3.nombre", locale), t("datos.hab3.desc", locale), "alto"),
                new Habilidad(t("datos.hab4.nombre", locale), t("datos.hab4.desc", locale), "alto")
        });

        model.addAttribute("idiomas", new Idioma[]{
                new Idioma("alto", t("datos.idioma.frances", locale)),
                new Idioma("medio", t("datos.idioma.ingles", locale))
        });

        return "curriculum";
    }

    // Devuelve el texto de la clave en el idioma elegido
    private String t(String clave, Locale locale) {
        return mensajes.getMessage(clave, null, locale);
    }
}
