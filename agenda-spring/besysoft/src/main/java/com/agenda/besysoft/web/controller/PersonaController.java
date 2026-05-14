package com.agenda.besysoft.web.controller;

import com.agenda.besysoft.domain.dto.PersonaDto;
import com.agenda.besysoft.domain.service.PersonaService;
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
@RequestMapping("/personas")
@Tag(name = "Personas", description = "Operaciones de personas en Agenda")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Operation(
            summary = "Obtener todas las personas",
            description = "Devuelve una lista con todas las personas registradas en la agenda"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de personas obtenida correctamente"
    )
    @GetMapping
    public ResponseEntity<List<PersonaDto>> getAll() {
        return ResponseEntity.ok(this.personaService.getAll());
    }

    @Operation(
            summary = "Buscar persona por ID",
            description = "Obtiene una persona específica mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Persona encontrada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Persona no encontrada"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> getPersonaById(
            @Parameter(description = "ID de la persona", example = "1")
            @PathVariable long id
    ) {

        PersonaDto personaDto = this.personaService.getPersonaById(id);

        if (personaDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personaDto);
    }

    @Operation(
            summary = "Crear persona",
            description = "Crea una nueva persona en la agenda"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Persona creada correctamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PostMapping
    public ResponseEntity<PersonaDto> add(
            @RequestBody @Valid PersonaDto personaDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personaService.add(personaDto));
    }

    @Operation(
            summary = "Actualizar persona",
            description = "Actualiza los datos de una persona existente"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Persona actualizada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Persona no encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> update(
            @Parameter(description = "ID de la persona", example = "1")
            @PathVariable long id,

            @RequestBody @Valid PersonaDto personaDto
    ) {
        return ResponseEntity.ok(this.personaService.update(id, personaDto));
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<PersonaDto>> buscarPorNombre(
            @RequestParam String nombre
    ) {
        return ResponseEntity.ok(this.personaService.buscarPorNombre(nombre));
    }

    @GetMapping("/buscar/ciudad")
    public ResponseEntity<List<PersonaDto>> buscarPorCiudad(
            @RequestParam String ciudad
    ) {
        return ResponseEntity.ok(this.personaService.buscarPorCiudad(ciudad));
    }

    @GetMapping("/buscar/filtro")
    public ResponseEntity<List<PersonaDto>> buscarPorNombreApellidoYCiudades(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam List<String> ciudades
    ) {
        return ResponseEntity.ok(
                this.personaService.buscarPorNombreApellidoYCiudades(
                        nombre,
                        apellido,
                        ciudades
                )
        );
    }
}
