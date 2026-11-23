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
public class NuevaCasetaFormulario {

    @NotBlank(message = "Escribe la calle donde se situa la caseta.")
    @Pattern(regexp = "Antonio Bienvenida|Pascual Márquez|Juan Belmonte|Joselito el Gallo|" +
                    "Rafael el Gallo|Gitanillo de Triana|Costillares|" +
                    "Pepe Luis Vázquez|Manolo Vázquez|Curro Romero|" +
                    "Ignacio Sánchez Mejías|Bombita|Chicuelo|Pepe Hillo|Espartero",
            message = "Seleccione una de las calles disponibles.")
    private String calle;

    @NotNull(message = "Escriba el numero donde se situa la caseta.")
    @Min(value = 1, message = "Tiene que empezar en el 1 como minimo, no puede ser negativo.")
    @Max(value = 600, message = "El numero de la caseta no puede superar el numero 600.")
    private Integer numeroCalle;

    @NotNull(message = "Escriba el numero de socios de la caseta.")
    @Min(value = 1, message = "Tiene que haber el minimo de 1 socio.")
    @Max(value = 500, message = "Los socios no pueden superar el numero de 500 socios")
    private Long numSocios;

    @NotBlank(message = "Escriba el nombre de la caseta.")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres.")
    private String nombre;

    @Size(max = 300, message = "La descripción no puede ser más larga que 300 caracteres")
    private String descripcion;

    @Size(max = 300, message = "La url de la foto no puede ser más larga que 300 caracteres")
    private String foto;

    @NotNull(message = "Escriba los metros cuadrados de la caseta.")
    @DecimalMin(value = "20.0", message = "Los metros cuadrados no pueden ser menos que 20.0 por normativa.")
    @Digits(integer = 3, fraction = 2, message = "Use hasta 3 cifras enteras y 2 decimales.")
    private BigDecimal metrosCuadrados;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Indica la fecha de alta.")
    private LocalDate fechaAlta;


    private boolean publica=false;
}


