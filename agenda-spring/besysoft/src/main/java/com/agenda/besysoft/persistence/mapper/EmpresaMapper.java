package com.agenda.besysoft.persistence.mapper;

import com.agenda.besysoft.domain.dto.EmpresaDto;
import com.agenda.besysoft.persistence.entity.EmpresaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaDto toDto(EmpresaEntity entity);

    List<EmpresaDto> toDto(Iterable<EmpresaEntity> entities);

    EmpresaEntity toEntity(EmpresaDto dto);

    void updateEntityFromDto(
            EmpresaDto empresaDto,
            @MappingTarget EmpresaEntity empresaEntity
    );
}