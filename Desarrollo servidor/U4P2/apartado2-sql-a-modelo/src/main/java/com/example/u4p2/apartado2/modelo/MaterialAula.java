package com.example.u4p2.apartado2.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "material_aula")
@Getter
@Setter
@NoArgsConstructor
public class MaterialAula {

    @Id //Clave primaria
    @Column(name = "id")
    private Long id;

    //columna referencia con maximo 12 caracteres, no puede estar vacio y no puede repetirse
    @Column(name = "referencia",length = 12,nullable = false,unique = true)
    private String referencia;

    //columna descripcion con maximo 250 caracteres, no puede estar vacio
    @Column(name = "descripcion", length = 250, nullable = true)
    private String descripcion;

    //columna codigo con maximo 80 caracteres, no puede estar vacio
    @Column(name = "nombre_material",length = 80,nullable = false)
    private String nombre;

    //columna del coste de reposicon con 8 digitos en total y 2 de ellos que sean decimale y no puede estar vacio
    @Column(name = "coste_reposicion", precision = 8,scale = 2,nullable = false)
    private BigDecimal costeReposicion;

    //columna de unidades no puede estar vacio y es short porque en sql es smallint
    @Column(name = "unidades",nullable = false)
    private Short unidades;
}
