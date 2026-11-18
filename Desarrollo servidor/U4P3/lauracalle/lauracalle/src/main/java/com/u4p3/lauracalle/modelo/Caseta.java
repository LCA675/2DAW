package com.u4p3.lauracalle.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Entity
@Table(name = "caseta")
@Getter
@Setter
@NoArgsConstructor
@IdClass(ClaveCaseta.class)
public class Caseta {

    @Id
    private ClaveCaseta calleYnumero;

    @Column(name = "numSocios", nullable = false)
    private Long numSocios;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    //Faltan campos de fotos, lista de usuarios, tablon, reseñas,


}
