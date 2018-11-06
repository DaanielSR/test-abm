package com.mavha.controllers;


import com.mavha.entities.PersonaEntity;
import com.mavha.repositories.PersonasRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonasControllerTest {

    @Autowired
    private PersonasRepository personasRepository;

    @Test
    public void getAll() throws Exception {
        List<PersonaEntity> personas = new ArrayList<>();
        personas.add(new PersonaEntity(1L,"Daniel","Catalano",23));
        personas.add(new PersonaEntity(2L,"Daniel","Rodo",24));

        personasRepository.saveAll(personas);

        assert (personas.size()==personasRepository.findAll().size());


    }

    @Test
    public void getByDni() throws Exception {
        personasRepository.save(new PersonaEntity(1L,"Daniel","Catalano",23));

        Predicate<PersonaEntity> predicate = persona ->
                persona.getDni().equals(1L);

        assert (predicate.test(personasRepository.findByDni(1L)));
    }

    @Test
    public void getByNombre() throws Exception {
        personasRepository.save(new PersonaEntity(1L,"Daniel","Catalano",23));

        Predicate<PersonaEntity> predicate = persona ->
                persona.getNombre().equals("Daniel");

        assert personasRepository.findAllByNombre("Daniel")
                .stream().anyMatch(predicate);
    }

    @Test
    public void getByEdad() throws Exception {
        personasRepository.save(new PersonaEntity(1L,"Daniel","Catalano",23));

        Predicate<PersonaEntity> predicate = persona ->
                persona.getEdad().equals(23);

        assert personasRepository.findAllByEdad(23)
                .stream().anyMatch(predicate);
    }

    @Test
    public void post() throws Exception {
        personasRepository.save(new PersonaEntity(1L,"Daniel","Catalano",23));
        assert personasRepository.findAll().size()>0;
    }


}