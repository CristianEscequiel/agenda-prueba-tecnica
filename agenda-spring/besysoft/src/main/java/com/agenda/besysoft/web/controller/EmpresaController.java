package com.agenda.besysoft.web.controller;

import com.agenda.besysoft.domain.dto.EmpresaDto;
import com.agenda.besysoft.domain.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresas", description = "Operaciones de empresas en Agenda")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Operation(
            summary = "Obtener todas las empresas",
            description = "Devuelve una lista con todas las empresas registradas"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de empresas obtenida correctamente"
    )
    @GetMapping
    public ResponseEntity<List<EmpresaDto>> getAll() {
        return ResponseEntity.ok(this.empresaService.getAll());
    }

    @Operation(
            summary = "Buscar empresa por ID",
            description = "Obtiene una empresa específica mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresa encontrada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Empresa no encontrada"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDto> getEmpresaById(
            @Parameter(description = "ID de la empresa", example = "1")
            @PathVariable long id
    ) {

        EmpresaDto empresaDto = this.empresaService.getEmpresaById(id);

        if (empresaDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresaDto);
    }

    @Operation(
            summary = "Crear empresa",
            description = "Crea una nueva empresa en la agenda"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Empresa creada correctamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PostMapping
    public ResponseEntity<EmpresaDto> add(
            @RequestBody @Valid EmpresaDto empresaDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.empresaService.add(empresaDto));
    }

    @Operation(
            summary = "Actualizar empresa",
            description = "Actualiza los datos de una empresa existente"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresa actualizada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Empresa no encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDto> update(
            @Parameter(description = "ID de la empresa", example = "1")
            @PathVariable long id,

            @RequestBody @Valid EmpresaDto empresaDto
    ) {
        return ResponseEntity.ok(this.empresaService.update(id, empresaDto));
    }
    @PostMapping("/{empresaId}/contactos/{personaId}")
    public ResponseEntity<EmpresaDto> agregarContacto(
            @PathVariable long empresaId,
            @PathVariable long personaId
    ) {
        EmpresaDto empresaDto = this.empresaService.agregarContacto(
                empresaId,
                personaId
        );

        if (empresaDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empresaDto);
    }
}