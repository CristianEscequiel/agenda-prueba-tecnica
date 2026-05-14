package com.agenda.besysoft.persistence.mapper;

import com.agenda.besysoft.domain.dto.PersonaDto;
import com.agenda.besysoft.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDto toDto(PersonaEntity entity);
    List<PersonaDto> toDto(Iterable<PersonaEntity> entities);
    PersonaEntity toEntity(PersonaDto dto);
    void updateEntityFromDto(PersonaDto personaDto, @MappingTarget PersonaEntity personaEntity);
}
