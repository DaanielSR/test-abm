package com.mavha.repositories;


import com.mavha.entities.PersonaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends CrudRepository<PersonaEntity,Long>{
    List<PersonaEntity> findAll();
    PersonaEntity findByDni(Long dni);
    List<PersonaEntity> findAllByNombre(String nombre);
    List<PersonaEntity> findAllByEdad(Integer edad);

}
