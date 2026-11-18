package com.example.u4p2.apartado2.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puesto_trabajo")
@Getter
@Setter
@NoArgsConstructor
public class PuestoTrabajo {
    @Id //Clave primaria
    @Column(name = "id")
    private Long id;

    //columna codigo_puesto con maximo 12 caracteres, no puede estar vacio y no puede repetirse
    @Column(name = "codigo_puesto", length = 10,nullable = false,unique = true)
    private String codigo;

    //columna denominacion con maximo 60 caracteres, no puede estar vacio
    @Column(name = "denominacion", length = 60, nullable = false)
    private String denominacion;

    //columna planta, no puede estar vacio
    @Column(name = "planta", nullable = false)
    private Integer planta;

    //columna tiene electricidad booleano, no puede estar vacio
    @Column(name = "tiene_electricidad", nullable = false)
    private Boolean tieneElectricidad;

}
