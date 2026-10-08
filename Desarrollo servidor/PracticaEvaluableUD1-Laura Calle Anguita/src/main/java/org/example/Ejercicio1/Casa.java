package org.example.Ejercicio1;

public class Casa {
    protected double area;
    protected Tejado tejado;
    protected Pared[] paredes;

    public Casa(double area, Tejado tejado, Pared[] paredes) {
        this.area = area;
        this.tejado = tejado;
        this.paredes = paredes;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Tejado getTejado() {
        return tejado;
    }

    public void setTejado(Tejado tejado) {
        this.tejado = tejado;
    }

    public Pared[] getParedes() {
        return paredes;
    }

    public void setParedes(Pared[] paredes) {
        this.paredes = paredes;
    }
}
