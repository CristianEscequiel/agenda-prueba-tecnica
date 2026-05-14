package com.agenda.besysoft.persistence;

import com.agenda.besysoft.domain.dto.PersonaDto;
import com.agenda.besysoft.domain.exception.EmailAlreadyExistException;
import com.agenda.besysoft.domain.repositorty.PersonaRepository;
import com.agenda.besysoft.persistence.crud.CrudPersonaEntity;
import com.agenda.besysoft.persistence.entity.PersonaEntity;
import com.agenda.besysoft.persistence.mapper.PersonaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaEntityRepository implements PersonaRepository {

    private final CrudPersonaEntity crudPersonaEntity;
    private final PersonaMapper personaMapper;
    public PersonaEntityRepository(CrudPersonaEntity crudPersonaEntity, PersonaMapper personaMapper){
        this.crudPersonaEntity = crudPersonaEntity;
        this.personaMapper = personaMapper;
    }

    @Override
    public List<PersonaDto> getAll() {
        return this.personaMapper.toDto(this.crudPersonaEntity.findAll());
    }

    @Override
    public PersonaDto getPersonaById(long id) {
        PersonaEntity personaEntity = this.crudPersonaEntity.findById(id).orElse(null);
        return this.personaMapper.toDto(personaEntity);
    }

    @Override
    public PersonaDto save(PersonaDto personaDto) {
        if (this.crudPersonaEntity.findFirstByEmail(personaDto.email()) != null) {
            throw new EmailAlreadyExistException((personaDto.email()));
        }
        PersonaEntity personaEntity = this.personaMapper.toEntity(personaDto);
        return this.personaMapper.toDto(this.crudPersonaEntity.save(personaEntity));
    }

    @Override
    public PersonaDto update(long id, PersonaDto personaDto) {

        PersonaEntity personaEntity = this.crudPersonaEntity.findById(id)
                .orElse(null);
        if (personaEntity == null) {
            return null;
        }
        PersonaEntity personaConMismoEmail =
                this.crudPersonaEntity.findFirstByEmail(personaDto.email());
        if ( personaConMismoEmail != null && !personaConMismoEmail.getId().equals(id)
        ) {
            throw new EmailAlreadyExistException(personaDto.email());
        }
        this.personaMapper.updateEntityFromDto(personaDto, personaEntity);
        return this.personaMapper.toDto(
                this.crudPersonaEntity.save(personaEntity)
        );
    }

    @Override
    public List<PersonaDto> buscarPorNombre(String nombre) {
        return this.personaMapper.toDto(
                this.crudPersonaEntity.findByNombreIgnoreCase(nombre)
        );
    }

    @Override
    public List<PersonaDto> buscarPorCiudad(String ciudad) {
        return this.personaMapper.toDto(
                this.crudPersonaEntity.findByCiudadIgnoreCase(ciudad)
        );
    }

    @Override
    public List<PersonaDto> buscarPorNombreApellidoYCiudades(
            String nombre,
            String apellido,
            List<String> ciudades
    ) {
        return this.personaMapper.toDto(
                this.crudPersonaEntity.findByNombreIgnoreCaseAndApellidoIgnoreCaseAndCiudadIn(
                        nombre,
                        apellido,
                        ciudades
                )
        );
    }


}
