package com.agenda.besysoft.domain.service;

import com.agenda.besysoft.domain.dto.EmpresaDto;
import com.agenda.besysoft.domain.repositorty.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaDto> getAll() {
        return this.empresaRepository.getAll();
    }

    public EmpresaDto getEmpresaById(long id) {
        return this.empresaRepository.getEmpresaById(id);
    }

    public EmpresaDto add(EmpresaDto empresaDto) {
        return this.empresaRepository.save(empresaDto);
    }

    public EmpresaDto update(long id, EmpresaDto empresaDto) {
        return this.empresaRepository.update(id, empresaDto);
    }

    public EmpresaDto agregarContacto(long empresaId, long personaId) {
        return this.empresaRepository.agregarContacto(empresaId, personaId);
    }
}