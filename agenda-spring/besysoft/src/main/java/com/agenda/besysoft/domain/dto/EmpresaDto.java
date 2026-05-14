package com.agenda.besysoft.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EmpresaDto(
        Long id,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El CUIT es obligatorio")
        String cuit,

        @NotBlank(message = "La ciudad es obligatoria")
        String ciudad,

        List<PersonaDto> contactos

) {
}