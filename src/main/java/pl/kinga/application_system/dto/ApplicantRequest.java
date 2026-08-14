package pl.kinga.application_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ApplicantRequest(
        @NotBlank(message = "Imie nie moze byc puste")
        String firstName,

        @NotBlank(message = "Nazwisko nie moze byc puste")
        String lastName,

        @Email(message = "Niepoprawny format email")
        @NotBlank(message = "Email nie moze byc pusty")
        String email
) {}
