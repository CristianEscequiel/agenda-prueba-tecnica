package com.agenda.besysoft.persistence.crud;

import com.agenda.besysoft.persistence.entity.EmpresaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEmpresaEntity extends CrudRepository<EmpresaEntity, Long> {

    EmpresaEntity findFirstByCuit(String cuit);

}