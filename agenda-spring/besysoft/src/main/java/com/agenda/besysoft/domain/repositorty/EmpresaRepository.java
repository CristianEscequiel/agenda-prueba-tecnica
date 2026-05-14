package com.agenda.besysoft.domain.repositorty;

import com.agenda.besysoft.domain.dto.EmpresaDto;

import java.util.List;

public interface EmpresaRepository {

    List<EmpresaDto> getAll();

    EmpresaDto getEmpresaById(long id);

    EmpresaDto save(EmpresaDto empresaDto);

    EmpresaDto update(long id, EmpresaDto empresaDto);

    EmpresaDto agregarContacto(long empresaId, long personaId);

}