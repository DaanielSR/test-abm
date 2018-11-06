package com.mavha.controllers;


import com.mavha.models.Persona;
import com.mavha.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/personas")
public class PersonasController {

    private PersonasService personasService;

    @Autowired
    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(personasService.getAll());
    }

    @GetMapping(params = "dni")
    public ResponseEntity getByDni(@RequestParam("dni") Long dni){
        return ResponseEntity.ok(personasService.getByDni(dni));
    }

    @GetMapping(params = "nombre")
    public ResponseEntity getByNombre(@RequestParam("nombre") String nombre){
        return ResponseEntity.ok(personasService.getAllByNombre(nombre));
    }

    @GetMapping(params = "edad")
    public ResponseEntity getByEdad(@RequestParam("edad") Integer edad){
        return ResponseEntity.ok(personasService.getAllByEdad(edad));
    }
    @PostMapping
    public ResponseEntity post(@Valid @RequestBody Persona persona){
        personasService.savePersona(persona);
        return ResponseEntity.ok().build();
    }
}
