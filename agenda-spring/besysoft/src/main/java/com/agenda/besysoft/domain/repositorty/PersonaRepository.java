package com.agenda.besysoft.domain.repositorty;

import com.agenda.besysoft.domain.dto.PersonaDto;

import java.util.List;

public interface PersonaRepository {
    List<PersonaDto> getAll();
    PersonaDto getPersonaById(long id);
    PersonaDto save(PersonaDto personaDto);
    PersonaDto update(long id , PersonaDto personaDto);

    List<PersonaDto> buscarPorNombre(String nombre);
    List<PersonaDto> buscarPorCiudad(String ciudad);
    List<PersonaDto> buscarPorNombreApellidoYCiudades(
            String nombre,
            String apellido,
            List<String> ciudades
    );
}
