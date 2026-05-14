package com.agenda.besysoft.persistence.crud;

import com.agenda.besysoft.persistence.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudPersonaEntity extends CrudRepository<PersonaEntity, Long> {

    PersonaEntity findFirstByEmail(String email);

    List<PersonaEntity> findByNombreIgnoreCase(String nombre);

    List<PersonaEntity> findByCiudadIgnoreCase(String ciudad);

    List<PersonaEntity> findByNombreIgnoreCaseAndApellidoIgnoreCaseAndCiudadIn(
            String nombre,
            String apellido,
            List<String> ciudades
    );
}