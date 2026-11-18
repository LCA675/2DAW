package com.example.u4p2.apartado1.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "espacio")
@Getter
@Setter
@NoArgsConstructor
public class Espacio {
    @Id   //Clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La id se va incrementando
    private Long id;

    //columna codigo con maximo 8 caracteres, no puede estar vacio y no puede repetirse
    @Column(name = "codigo_espacio", length = 8, nullable = false, unique = true)
    private String codigo;

    //columna nombre con maximo 60 caracteres, no puede estar vacio
    @Column(name = "nombre_espacio",length = 60,nullable = false)
    private String nombre;

    //columna aforo, no puede estar vacio
    @Column(name = "aforo",nullable = false)
    private int aforo;

    //columna planta, no puede estar vacio
    @Column(name = "planta", nullable = false)
    private int planta;

    //columna de si es accesible, booleano y es obligatorio
    @Column(name = "accesible", nullable = false)
    private boolean accesible;

}
