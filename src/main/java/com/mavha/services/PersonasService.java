package com.mavha.services;


import com.mavha.entities.PersonaEntity;
import com.mavha.models.Persona;
import com.mavha.repositories.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService {

    private  PersonasRepository personasRepository;

    @Autowired
    public PersonasService(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
    }

    public List<PersonaEntity> getAll(){
        return personasRepository.findAll();
    }

    public PersonaEntity getByDni(Long dni) {
        return personasRepository.findByDni(dni);
    }

    public List<PersonaEntity> getAllByNombre(String nombre){
        return personasRepository.findAllByNombre(nombre);
    }
    public List<PersonaEntity> getAllByEdad(Integer edad){
        return personasRepository.findAllByEdad(edad);
    }

    public void savePersona(Persona persona){
        personasRepository.save(new PersonaEntity(persona));
    }
}
