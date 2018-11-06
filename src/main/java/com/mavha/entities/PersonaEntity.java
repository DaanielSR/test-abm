package com.mavha.entities;


import com.mavha.models.Persona;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonaEntity {

    @Id
    private Long dni;
    private String nombre;
    private String apellido;
    private Integer edad;

    public PersonaEntity() {
    }

    public PersonaEntity(Long dni, String nombre, String apellido, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public PersonaEntity(Persona persona) {
        this.dni=persona.getDni();
        this.nombre=persona.getNombre();
        this.apellido=persona.getApellido();
        this.edad=persona.getEdad();
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
