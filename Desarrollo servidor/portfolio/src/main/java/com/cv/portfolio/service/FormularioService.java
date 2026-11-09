package com.cv.portfolio.service;

import com.cv.portfolio.model.PortfolioForm;
import com.cv.portfolio.model.ProyectoForm;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormularioService {

    private static final List<String> CATEGORIAS = List.of("Aplicaciones", "Sitios web", "Diseño");
    private static final List<String> ESTADOS = List.of("En curso", "Terminado");
    private static final String PATRON_CORREO = "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$";

    // Devuelve los errores del formulario: campo -> clave del mensaje de error
    public Map<String, String> validar(PortfolioForm form) {
        Map<String, String> errores = new LinkedHashMap<>();

        if (enBlanco(form.getNombre())) {
            errores.put("nombre", "error.obligatorio");
        }
        if (enBlanco(form.getTitular())) {
            errores.put("titular", "error.obligatorio");
        }
        if (enBlanco(form.getPresentacion())) {
            errores.put("presentacion", "error.obligatorio");
        }

        // El correo es opcional, solo se comprueba si se ha escrito
        if (!enBlanco(form.getCorreo()) && !form.getCorreo().trim().matches(PATRON_CORREO)) {
            errores.put("correo", "error.correo");
        }

        for (int i = 0; i < form.getProyectos().size(); i++) {
            ProyectoForm proyecto = form.getProyectos().get(i);

            // Las filas vacías no dan error, luego se quitan
            if (proyecto.estaVacio()) {
                continue;
            }

            // Mismo nombre que el campo del HTML, por ejemplo proyectos[0].titulo
            String campo = "proyectos[" + i + "].";

            if (enBlanco(proyecto.getTitulo())) {
                errores.put(campo + "titulo", "error.obligatorio");
            }
            if (enBlanco(proyecto.getAnio())) {
                errores.put(campo + "anio", "error.obligatorio");
            } else if (!esNumero(proyecto.getAnio())) {
                errores.put(campo + "anio", "error.anio");
            }
            if (proyecto.getCategoria() == null || !CATEGORIAS.contains(proyecto.getCategoria())) {
                errores.put(campo + "categoria", "error.obligatorio");
            }
            if (proyecto.getEstado() == null || !ESTADOS.contains(proyecto.getEstado())) {
                errores.put(campo + "estado", "error.obligatorio");
            }
            if (enBlanco(proyecto.getDescripcion())) {
                errores.put(campo + "descripcion", "error.obligatorio");
            }
        }

        return errores;
    }

    // Añade una fila o quita la fila indicada en "quitar-N"
    public void gestionarFilas(PortfolioForm form, String accion, int maxProyectos) {
        List<ProyectoForm> proyectos = form.getProyectos();

        if (accion.equals("anadir") && proyectos.size() < maxProyectos) {
            proyectos.add(new ProyectoForm());
        } else if (accion.startsWith("quitar-")) {
            String indice = accion.substring("quitar-".length());
            if (esNumero(indice) && Integer.parseInt(indice) < proyectos.size()) {
                proyectos.remove(Integer.parseInt(indice));
            }
            // Siempre queda al menos una fila
            if (proyectos.isEmpty()) {
                proyectos.add(new ProyectoForm());
            }
        }
    }

    // Quita las filas que el usuario no ha rellenado
    public void quitarFilasVacias(PortfolioForm form) {
        form.getProyectos().removeIf(ProyectoForm::estaVacio);
    }

    private boolean enBlanco(String texto) {
        return texto == null || texto.isBlank();
    }

    // true si el texto es un número entero positivo (máximo 9 cifras para que quepa en un int)
    private boolean esNumero(String texto) {
        return texto.trim().matches("\\d{1,9}");
    }
}
