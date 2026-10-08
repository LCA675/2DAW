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
}
