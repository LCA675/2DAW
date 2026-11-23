package com.u4p3.lauracalle.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "caseta")
@Getter
@Setter
@NoArgsConstructor
//La idclass es una solucion para mi caso porque mi tabla necesita 2 campos como ID porque si no no se identificaria bien
//Lo arreglo haciendo una clase nueva con esos dos campos y abajo defino que la clase de la id sera esa clase ClaveCaseta
@IdClass(ClaveCaseta.class)
public class Caseta {

    @Id
    private String calle;

    @Id
    private Integer numeroCalle;

    @Column(name = "numSocios", nullable = false)
    private Long numSocios;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "foto", length = 300)
    private String foto;

    @Column(name = "metrosCuadrados", nullable = false)
    private BigDecimal metrosCuadrados;

    @Column(name = "fechaAlta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "publica", nullable = false)
    private boolean publica;


}
