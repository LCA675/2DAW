package com.u4p3.lauracalle.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//formulario para poder registrar una caseta
public class NuevaCasetaFormulario {
    //Podremos seleccionar solo una de las opciones que nos muestra en el Pattern y no puede estar en blanco
    @NotBlank(message = "Escribe la calle donde se situa la caseta.")
    @Pattern(regexp = "Antonio Bienvenida|Pascual Márquez|Juan Belmonte|Joselito el Gallo|" +
            "Rafael el Gallo|Gitanillo de Triana|Costillares|" +
            "Pepe Luis Vázquez|Manolo Vázquez|Curro Romero|" +
            "Ignacio Sánchez Mejías|Bombita|Chicuelo|Pepe Hillo|Espartero",
            message = "Seleccione una de las calles disponibles.")
    private String calle;
    //Introduciremos el numero de la caseta y no puede ser nulo y el minimo es 1 y el maximo 600
    @NotNull(message = "Escriba el numero donde se situa la caseta.")
    @Min(value = 1, message = "Tiene que empezar en el 1 como minimo, no puede ser negativo.")
    @Max(value = 600, message = "El numero de la caseta no puede superar el numero 600.")
    private Integer numeroCalle;
    //Introduciremos el numero de socios que tiene la caseta, como minimo habra 1 y como maximo 500, no puede ser nulo
    @NotNull(message = "Escriba el numero de socios de la caseta.")
    @Min(value = 1, message = "Tiene que haber el minimo de 1 socio.")
    @Max(value = 500, message = "Los socios no pueden superar el numero de 500 socios")
    private Long numSocios;
    //Introduciremos el nombre de la caseta que tendra como maximo 100 caracterees y no puede estar en blanco
    @NotBlank(message = "Escriba el nombre de la caseta.")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres.")
    private String nombre;
    //La descripcion no es obligatoria y como maximo podra tener 300 caracteres
    @Size(max = 300, message = "La descripción no puede ser más larga que 300 caracteres")
    private String descripcion;
    //Aqui podremos poner una url para teneer una foto de la caseta, no puede ser mas larga de 300 caracteres y nno es obligatoria
    @Size(max = 300, message = "La url de la foto no puede ser más larga que 300 caracteres")
    private String foto;
    //Aqui podremos escribir los metros cuadrados que tiene la caseta, no puede ser nulo, el minimo son 20 y solo puede usar 3 cifras y 2 decimales
    @NotNull(message = "Escriba los metros cuadrados de la caseta.")
    @DecimalMin(value = "20.0", message = "Los metros cuadrados no pueden ser menos que 20.0 por normativa.")
    @Digits(integer = 3, fraction = 2, message = "Use hasta 3 cifras enteras y 2 decimales.")
    private BigDecimal metrosCuadrados;
    //Aqui podremos poner la fecha en la que se dio de alta la caseta y no puede ser nula
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Indica la fecha de alta.")
    private LocalDate fechaAlta;

//Un booleano para saber si es publica o privada, esta en false porque la mayoria son privadas
    private boolean publica = false;
}


