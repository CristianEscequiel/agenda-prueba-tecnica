package com.agenda.besysoft.domain.service;

import com.agenda.besysoft.domain.dto.PersonaDto;
import com.agenda.besysoft.domain.repositorty.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<PersonaDto> getAll() {
        return this.personaRepository.getAll();
    }
    public PersonaDto getPersonaById(long id) {
            return this.personaRepository.getPersonaById(id);
    }
    public PersonaDto add(PersonaDto personaDto) {
        return this.personaRepository.save(personaDto);
    }
    public PersonaDto update(long id ,PersonaDto personaDto){
        return this.personaRepository.update(id , personaDto);
    }

    public List<PersonaDto> buscarPorNombre(String nombre) {
        return this.personaRepository.buscarPorNombre(nombre);
    }

    public List<PersonaDto> buscarPorCiudad(String ciudad) {
        return this.personaRepository.buscarPorCiudad(ciudad);
    }

    public List<PersonaDto> buscarPorNombreApellidoYCiudades(
            String nombre,
            String apellido,
            List<String> ciudades
    ) {
        return this.personaRepository.buscarPorNombreApellidoYCiudades(
                nombre,
                apellido,
                ciudades
        );
    }
}
