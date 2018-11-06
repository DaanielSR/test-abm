package com.mavha.models;


import javax.validation.constraints.NotNull;

public class Persona {

    @NotNull
    private Long dni;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private Integer edad;

    public Persona() {
    }

    public Persona(Long dni, String nombre, String apellido, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }
}
