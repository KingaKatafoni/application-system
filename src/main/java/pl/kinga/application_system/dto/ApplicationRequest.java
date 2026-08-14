package pl.kinga.application_system.dto;

import jakarta.validation.constraints.NotBlank;

public record ApplicationRequest(
        @NotBlank(message = "Typ wniosku nie moze byc pusty")
        String type,

        @NotBlank(message = "Status nie moze byc pusty")
        String status
) {
}
