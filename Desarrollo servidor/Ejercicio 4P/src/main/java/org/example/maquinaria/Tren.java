package org.example.maquinaria;

import org.example.personal.Maquinista;
import java.util.Arrays;

public class Tren implements InyectableLocomotora, InyectableMaquinista {

    private Locomotora locomotora;
    private Maquinista maquinistaResponsable;
    private final Vagon[] vagones;

    public Tren(Locomotora locomotora, Maquinista maquinistaResponsable) {
        this.locomotora = locomotora;
        this.maquinistaResponsable = maquinistaResponsable;
        this.vagones = new Vagon[5];
    }

    @Override
    public void inyectarLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }
    @Override
    public void inyectarMaquinista(Maquinista maquinista) {
        this.maquinistaResponsable = maquinista;
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public Maquinista getMaquinistaResponsable() {
        return maquinistaResponsable;
    }

    public void setMaquinistaResponsable(Maquinista maquinistaResponsable) {
        this.maquinistaResponsable = maquinistaResponsable;
    }

    public Vagon[] getVagones() {
        return vagones;
    }

    @Override
    public String toString() {
        return "Tren{" +
                "locomotora=" + locomotora +
                ", maquinistaResponsable=" + maquinistaResponsable +
                ", vagones=" + Arrays.toString(getVagones()) +
                '}';
    }
}
