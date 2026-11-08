package com.cv.portfolio.service;

import com.cv.portfolio.model.PortfolioForm;
import com.cv.portfolio.model.ProyectoForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormularioService {

    private static final List<String> CATEGORIAS = List.of("Aplicaciones", "Sitios web", "Diseño");
    private static final List<String> ESTADOS = List.of("En curso", "Terminado");

    private static final String PATRON_CORREO = "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$";


    public Map<String, String> validar(PortfolioForm form, int maxProyectos) {
        // LinkedHashMap mantiene el orden en que se añaden los errores
        Map<String, String> errores = new LinkedHashMap<>();

        // Datos personales obligatorios
        if (enBlanco(form.getNombre())) {
            errores.put("nombre", "error.obligatorio");
        }
        if (enBlanco(form.getTitular())) {
            errores.put("titular", "error.obligatorio");
        }
        if (enBlanco(form.getPresentacion())) {
            errores.put("presentacion", "error.obligatorio");
        }

        // Correo opcional: solo se comprueba el formato si se ha escrito algo
        if (!enBlanco(form.getCorreo()) && !form.getCorreo().trim().matches(PATRON_CORREO)) {
            errores.put("correo", "error.correo");
        }

        // Límite de proyectos (aunque se hayan añadido filas manipulando el formulario)
        if (form.getProyectos().size() > maxProyectos) {
            errores.put("proyectos", "error.maximo");
        }

        // Se recorre con índice para saber a qué fila pertenece cada error
        for (int i = 0; i < form.getProyectos().size(); i++) {
            ProyectoForm proyecto = form.getProyectos().get(i);

            // Fila completamente vacía: no es un proyecto, se descarta sin error
            if (proyecto.estaVacio()) {
                continue;
            }

            // La clave coincide con el nombre del campo en el HTML: proyectos[0].titulo
            String prefijo = "proyectos[" + i + "].";

            if (enBlanco(proyecto.getTitulo())) {
                errores.put(prefijo + "titulo", "error.obligatorio");
            }

            if (enBlanco(proyecto.getAnio())) {
                errores.put(prefijo + "anio", "error.obligatorio");
            } else {
                // El año llega como texto: se intenta convertir para comprobar que es un número
                try {
                    Integer.parseInt(proyecto.getAnio().trim());
                } catch (NumberFormatException e) {
                    errores.put(prefijo + "anio", "error.anio");
                }
            }

            // Se comprueba null antes: List.of(...).contains(null) lanzaría una excepción
            if (proyecto.getCategoria() == null || !CATEGORIAS.contains(proyecto.getCategoria())) {
                errores.put(prefijo + "categoria", "error.obligatorio");
            }

            if (proyecto.getEstado() == null || !ESTADOS.contains(proyecto.getEstado())) {
                errores.put(prefijo + "estado", "error.obligatorio");
            }

            if (enBlanco(proyecto.getDescripcion())) {
                errores.put(prefijo + "descripcion", "error.obligatorio");
            }
        }

        return errores;
    }

    public void gestionarFilas(PortfolioForm form, String accion, int maxProyectos) {
        List<ProyectoForm> proyectos = form.getProyectos();

        if (accion.equals("anadir")) {
            if (proyectos.size() < maxProyectos) {
                proyectos.add(new ProyectoForm());
            }
        } else if (accion.startsWith("quitar-")) {
            try {
                // "quitar-2".substring(7) = "2"
                int indice = Integer.parseInt(accion.substring(7));
                if (indice >= 0 && indice < proyectos.size()) {
                    proyectos.remove(indice);
                }
            } catch (NumberFormatException e) {
                // Valor manipulado que no es un número: no se quita nada
            }

            // Siempre tiene que quedar al menos una fila para seguir editando
            if (proyectos.isEmpty()) {
                proyectos.add(new ProyectoForm());
            }
        }
    }

    // Devuelve solo las filas con datos (se usa antes de mostrar la vista previa)
    public List<ProyectoForm> quitarFilasVacias(List<ProyectoForm> proyectos) {
        List<ProyectoForm> conDatos = new ArrayList<>();
        for (ProyectoForm proyecto : proyectos) {
            if (!proyecto.estaVacio()) {
                conDatos.add(proyecto);
            }
        }
        return conDatos;
    }

    private boolean enBlanco(String texto) {
        return texto == null || texto.isBlank();
    }
}