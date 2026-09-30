package org.example;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO{
    private List<Libro> libros;

    public LibroDAOImpl(){
        this.libros = new ArrayList<>();
    }

    @Override
    public List<Libro> obtenerTodos() {
        return this.libros;
    }

    @Override
    public Libro obtenerPorID(int id) {
        for (int i = 0; i < this.libros.size(); i++){
            if (this.libros.get(i).getId()==id){
                return this.libros.get(i);
            }
        }
        return null;
    }

    @Override
    public void agregar(Libro libro) {
        for (int i = 0; i < this.libros.size(); i++){
            if (this.libros.get(i).getId()==libro.getId()){
                System.out.println("No se puede añadir, coincide en ID");;
                break;
            }
        }
        System.out.println("Añadiendo libro...");
        this.libros.add(libro);
        System.out.println("Libro añadido");

    }

    @Override
    public void actualizar(Libro libro) {
        for (int i = 0; i < this.libros.size(); i++){
            if (this.libros.get(i).getId()==libro.getId()){
                this.libros.set(i, libro);
                System.out.println("Libro actualizado");
                break;
            }
        }
        System.out.println("No hay ningun libro que coincida con el ID introducido");
    }

    @Override
    public void eliminar(int id) {
        for (int i = 0; i < this.libros.size(); i++){
            if (this.libros.get(i).getId()==id){
                this.libros.remove(i);
                System.out.println("Libro eliminado");
                break;
            }
        }
        System.out.println("No hay ningun libro que coincida con el ID introducido");
    }
}
