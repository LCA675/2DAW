package com.aulamaker.entregaP3P4;

import jakarta.validation.constraints.*;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
//Guardara los datos que el usuario introduzca por teclado en el formulario
public class SolicitudPrestamoFormulario {


    // Obligatorio y maximo 60 caracteres
    @NotBlank(message = "Escriba un nombre")
    @Size(max = 60, message = "Nombre muy largo")
    private String nombre;

    // Obligatorio, con formato correo y maximo 120 caracteres
    @NotBlank(message = "Escriba un email")
    @Size(max = 120, message = "Correo electrónico muy largo")
    @Email(message = "Formato no valido para el correo electronico")
    private String email;

    //  se comprueba que no esté vacío.
    @NotBlank(message = "Introduzca un material")
    private String material;

    // Integer para que cuando el campo esté vacío sea null y lo detecte el @NotNull
    @NotNull(message = "Añada una cantidad")
    @Min(value = 1, message = "Lo minimo es 1")
    @Max(value = 3, message = "Lo máximo son 3")
    private Integer unidades;

    // LocalDate con formato año-mes-día
    @NotNull(message = "Introduzca una fecha de recogida")
    @FutureOrPresent(message = "Tiene que ser una fecha actual o futura")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecog;

    // LocalDate con formato año-mes-día
    @NotNull(message = "Introduzca una fecha de devolución")
    @FutureOrPresent(message = "Tiene que ser una fecha actual o futura")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevo;

    // Entre 30 y 400 caracteres
    @NotBlank(message = "Tiene que escribir un motivo")
    @Size(min = 30, max = 400, message = "Tiene que ser entre 30 y 400 caracteres")
    private String motivo;

    // La casilla tiene que estar marcada para poder enviar la solicitud
    @AssertTrue(message = "Debe aceptar los términos")
    private boolean acepta;


//getter y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getUnidades() {
        return this.unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public LocalDate getFechaRecog() {
        return fechaRecog;
    }

    public void setFechaRecog(LocalDate fechaRecog) {
        this.fechaRecog = fechaRecog;
    }

    public LocalDate getFechaDevo() {
        return fechaDevo;
    }

    public void setFechaDevo(LocalDate fechaDevo) {
        this.fechaDevo = fechaDevo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAcepta() {
        return acepta;
    }

    public void setAcepta(boolean acepta) {
        this.acepta = acepta;
    }
}
