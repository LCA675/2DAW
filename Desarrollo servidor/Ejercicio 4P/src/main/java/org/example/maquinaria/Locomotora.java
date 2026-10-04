package org.example.maquinaria;

import org.example.personal.Mecanico;

public class Locomotora implements InyectableMecanico {
    private String matricula;
    private int potenciaMotor;
    private int anioFabricacion;
    private Mecanico mecanicoEncargado;

    public Locomotora(String matricula, int potenciaMotor, int anioFabricacion, Mecanico mecanicoEncargado) {
        this.matricula = matricula;
        this.potenciaMotor = potenciaMotor;
        this.anioFabricacion = anioFabricacion;
        this.mecanicoEncargado = mecanicoEncargado;
    }

    public Locomotora(String matricula, int potenciaMotor, int anioFabricacion) {
        this(matricula, potenciaMotor, anioFabricacion, null);
    }

    @Override
    public void inyectarMecanico(Mecanico mecanico) {
        this.mecanicoEncargado = mecanico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getAñoFabricacion() {
        return anioFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.anioFabricacion = añoFabricacion;
    }

    public Mecanico getMecanicoEncargado() {
        return mecanicoEncargado;
    }

    public void setMecanicoEncargado(Mecanico mecanicoEncargado) {
        this.mecanicoEncargado = mecanicoEncargado;
    }

    @Override
    public String toString() {
        return "Locomotora{" +
                "matricula='" + matricula + '\'' +
                ", potenciaMotor=" + potenciaMotor +
                ", anioFabricacion=" + anioFabricacion +
                ", mecanicoEncargado=" + mecanicoEncargado +
                '}';
    }
}
