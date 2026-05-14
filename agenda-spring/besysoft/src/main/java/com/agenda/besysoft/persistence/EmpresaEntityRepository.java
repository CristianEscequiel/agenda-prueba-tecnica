package com.agenda.besysoft.persistence;

import com.agenda.besysoft.domain.dto.EmpresaDto;
import com.agenda.besysoft.domain.repositorty.EmpresaRepository;
import com.agenda.besysoft.persistence.crud.CrudEmpresaEntity;
import com.agenda.besysoft.persistence.crud.CrudPersonaEntity;
import com.agenda.besysoft.persistence.entity.EmpresaEntity;
import com.agenda.besysoft.persistence.entity.PersonaEntity;
import com.agenda.besysoft.persistence.mapper.EmpresaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpresaEntityRepository implements EmpresaRepository {

    private final CrudEmpresaEntity crudEmpresaEntity;
    private final CrudPersonaEntity crudPersonaEntity;
    private final EmpresaMapper empresaMapper;

    public EmpresaEntityRepository(
            CrudEmpresaEntity crudEmpresaEntity,
            CrudPersonaEntity crudPersonaEntity,
            EmpresaMapper empresaMapper
    ) {
        this.crudEmpresaEntity = crudEmpresaEntity;
        this.crudPersonaEntity = crudPersonaEntity;
        this.empresaMapper = empresaMapper;
    }

    @Override
    public List<EmpresaDto> getAll() {
        return this.empresaMapper.toDto(this.crudEmpresaEntity.findAll());
    }

    @Override
    public EmpresaDto getEmpresaById(long id) {
        EmpresaEntity empresaEntity = this.crudEmpresaEntity.findById(id).orElse(null);
        return this.empresaMapper.toDto(empresaEntity);
    }

    @Override
    public EmpresaDto save(EmpresaDto empresaDto) {
        EmpresaEntity empresaEntity = this.empresaMapper.toEntity(empresaDto);
        return this.empresaMapper.toDto(this.crudEmpresaEntity.save(empresaEntity));
    }

    @Override
    public EmpresaDto update(long id, EmpresaDto empresaDto) {
        EmpresaEntity empresaEntity = this.crudEmpresaEntity.findById(id).orElse(null);

        if (empresaEntity == null) {
            return null;
        }

        this.empresaMapper.updateEntityFromDto(empresaDto, empresaEntity);

        return this.empresaMapper.toDto(this.crudEmpresaEntity.save(empresaEntity));
    }

    @Override
    public EmpresaDto agregarContacto(long empresaId, long personaId) {

        EmpresaEntity empresa = this.crudEmpresaEntity.findById(empresaId)
                .orElse(null);

        if (empresa == null) {
            return null;
        }

        PersonaEntity persona = this.crudPersonaEntity.findById(personaId)
                .orElse(null);

        if (persona == null) {
            return null;
        }

        empresa.getContactos().add(persona);

        return this.empresaMapper.toDto(
                this.crudEmpresaEntity.save(empresa)
        );
    }
}