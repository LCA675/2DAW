package org.example.Ejercicio1;

// esta es la clase casa que rescibe los demas componentes
public class Casa {
    protected double area;
    // aqui aplicamos inyeccion de dependensias pasando el tejado y las paredes desde fuera
    protected Tejado tejado;
    protected Pared[] paredes;

    // en el constructor resivimos los objetos ya creados para no hacer el new dentro
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
