package org.example.maquinaria;

import org.example.personal.Maquinista;

/**
 * Interfaz para aplicar el patrón Dependency Injection (Inyección por Interfaz)
 * en aquellas clases que dependan de un Maquinista.
 */
public interface InyectableMaquinista {
    void inyectarMaquinista(Maquinista maquinista);
}
