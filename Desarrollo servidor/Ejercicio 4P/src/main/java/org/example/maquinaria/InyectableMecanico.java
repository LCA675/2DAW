package org.example.maquinaria;

import org.example.personal.Mecanico;

/**
 * Interfaz para aplicar el patrón Dependency Injection (Inyección por Interfaz)
 * en aquellas clases que dependan de un Mecanico.
 */
public interface InyectableMecanico {
    void inyectarMecanico(Mecanico mecanico);
}
