package pl.kinga.application_system.dto;

import java.util.List;

public record ApplicantResponse(Long id, String fullName, String email, List<ApplicationResponse> applications) {
}
