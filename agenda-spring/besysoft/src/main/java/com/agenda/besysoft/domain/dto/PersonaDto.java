package com.agenda.besysoft.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonaDto(
        Long id,

        @NotNull(message = "El nombre es obligatorio")
        String nombre,
        @NotNull(message = "El apellido es obligatorio")
        String apellido,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email no tiene un formato válido")
        String email,
        Long telefono,
        String ciudad

) {
}
