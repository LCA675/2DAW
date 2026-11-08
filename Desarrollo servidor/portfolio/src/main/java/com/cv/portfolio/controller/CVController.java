package com.cv.portfolio.controller;


import com.cv.portfolio.model.Estudio;
import com.cv.portfolio.model.Experiencia;
import com.cv.portfolio.model.Habilidad;
import com.cv.portfolio.model.Idioma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CVController {
    //Ponemos el Value para que coja el nombre que tenemos en el application properties cv.nombre
    @Value("${cv.nombre}")
    private String nombre;

    //Si se entra a la raiz de la web (/) se redirige al curriculum, asi no sale error 404
    @GetMapping("/")
    public String inicio() {
        return "redirect:/curriculum";
    }

    @GetMapping("/curriculum")
    public String mostrarCV(Model model) {
        //Datos que no guardo en ninguna clase
        String titular = "Estudiante de desarrollo de aplicaciones web";
        String correo = "example@gmail.com";
        String presentacion = "Soy Laura Calle Anguita de 20 años, y estoy realizando el grado superior de desarrollo de aplicaciones web en el IES Velazquez en Sevilla. Me interesa mucho el apartado del Backend y el Frontend y el desarrollo de las aplicaciones en general";

        //Array de estudios
        Estudio estudio1 = new Estudio("Sistemas microinformaticos y Redes","IES Ramon del valle Inclan","2023", "2025", false  );
        Estudio estudio2 = new Estudio("Desarrollo de aplicaciones web", "IES Velazquez", "2025", "", true );
        Estudio[] estudios = new Estudio[]{estudio1, estudio2};

        //Array Experiencia
        Experiencia exp1 = new Experiencia("Formación de prácticas", "NTTDATA", "Marzo 2025", "Junio 2025");
        Experiencia[] experiencias = new Experiencia[]{exp1};

        //Array Habilidades
        Habilidad hab1 = new Habilidad("Desarrollo backend con Java y Spring Boot", "Creación de aplicaciones web en el servidor, con controladores, servicios y acceso a datos siguiendo el patrón MVC.", "medio");
        Habilidad hab2 = new Habilidad("Maquetación web con HTML, CSS y Thymeleaf", "Diseño de interfaces adaptables y generación de vistas dinámicas desde el servidor.", "medio");
        Habilidad hab3 = new Habilidad("Despliegue y administración de servidores web", "Configuración de Apache, hosts virtuales y puesta en producción de aplicaciones web.", "alto");
        Habilidad hab4 = new Habilidad("Bases de datos relacionales (SQL)", "Diseño de modelos de datos, consultas y conexión de bases de datos con aplicaciones web.","alto");
        Habilidad[] habilidades = new Habilidad[]{hab1, hab2, hab3, hab4};

        //Array Idiomas
        Idioma idioma1 = new Idioma("alto", "Francés");
        Idioma idioma2 = new Idioma("medio", "Inglés");
        Idioma[] idiomas = new Idioma[]{idioma1, idioma2};

        //Añadimos los datos del CV al model
        model.addAttribute("nombre", nombre);
        model.addAttribute("titular", titular);
        model.addAttribute("correo", correo);
        model.addAttribute("presentacion", presentacion);
        model.addAttribute("estudios", estudios);
        model.addAttribute("experiencias", experiencias);
        model.addAttribute("habilidades", habilidades);
        model.addAttribute("idiomas", idiomas);


        return "curriculum";
    }

}
