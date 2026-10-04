package org.example.maquinaria;

class Vagon {
    private double capacidadMax;
    private double cargaActual;
    private String tipoMercancia;

    Vagon(double capacidadMax, double cargaActual, String tipoMercancia) {
        this.capacidadMax = capacidadMax;
        this.tipoMercancia = tipoMercancia;

        if (cargaActual>capacidadMax){
            System.out.println("Error en los datos de la carga asignando a 0");
            this.capacidadMax = 0;
            this.cargaActual = 0;
        }
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(double capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(double cargaActual) {
        if (cargaActual>this.capacidadMax){
            System.out.println("Error en los datos de la carga asignando a 0");
            this.cargaActual = 0;
        }
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    @Override
    public String toString() {
        return "Vagon{" +
                "capacidadMax=" + capacidadMax +
                ", cargaActual=" + cargaActual +
                ", tipoMercancia='" + tipoMercancia + '\'' +
                '}';
    }
}
