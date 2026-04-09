package org.karemeru.empresa.infraestructura.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmpresaRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El identificador es obligatorio")
        String identificador,

        @NotBlank(message = "La calle es obligatoria")
        String calle,

        @NotBlank(message = "La ciudad es obligatoria")
        String ciudad,

        @NotBlank(message = "El país es obligatorio")
        String pais,

        @NotBlank(message = "El teléfono es obligatorio")
        String telefono,

        @Email(message = "El email no es válido")
        @NotBlank(message = "El email es obligatorio")
        String email
) {}
