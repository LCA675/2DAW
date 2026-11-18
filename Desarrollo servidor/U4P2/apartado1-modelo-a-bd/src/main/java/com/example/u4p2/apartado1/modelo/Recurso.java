package com.example.u4p2.apartado1.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "recurso")
@Getter @Setter @NoArgsConstructor
public class Recurso {
    @Id   //Clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La id se va incrementando
    private Long id;

    //columna codigo con maximo 12 numeros, no puede estar vacio y no puede repetirse
    @Column(name = "codigo",length = 12,nullable = false,unique = true)
    private String codigo;

    //columna nombre con maximo 80 caracteres, no puede estar vacio
    @Column(name = "nombre",length = 80,nullable = false)
    private String nombre;

    //columna descripcion con maximo 250 caracteres, puede estar vacio
    @Column(name = "descripcion",length = 250,nullable = true)
    private String descripcion;

    //columna del coste de reposicon con 8 digitos en total y 2 de ellos que sean decimale
    @Column(name = "coste_reposicion", precision = 8, scale = 2,nullable = false)
    private BigDecimal costeReposicion;

    //columna de si es prestable, booleano y es obligatorio
    @Column(name = "prestable", nullable = false)
    private boolean prestable;
}
