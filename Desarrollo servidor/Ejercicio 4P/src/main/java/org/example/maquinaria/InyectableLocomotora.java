package org.example.maquinaria;

/**
 * Interfaz para aplicar el patrón Dependency Injection (Inyección por Interfaz)
 * en aquellas clases que dependan de una Locomotora.
 */
public interface InyectableLocomotora {
    void inyectarLocomotora(Locomotora locomotora);
}
