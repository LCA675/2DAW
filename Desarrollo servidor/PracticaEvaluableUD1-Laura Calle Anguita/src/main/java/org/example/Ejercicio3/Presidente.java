package org.example.Ejercicio3;

// patron singleton para que solo aya una instancia de presidente en toda la aplicasion
public class Presidente {
    private String nombre;
    private String apellidos;
    private int anioEleccion;

    // creamos la unica instansia aqui mismo de forma estatica
    private static final Presidente INSTANCIA = new Presidente();

    // el constructor lo pongo privado para que nadie pueda acer new Presidente() desde fuera
    private Presidente() {

    }

    // este metodo publico es el que te da la unica instancia que exite
    public static Presidente instancia(){
        return INSTANCIA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnioEleccion() {
        return anioEleccion;
    }

    public void setAnioEleccion(int anioEleccion) {
        this.anioEleccion = anioEleccion;
    }
}
