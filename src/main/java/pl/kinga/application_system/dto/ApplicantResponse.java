package pl.kinga.application_system.dto;

import pl.kinga.application_system.model.Visit;

import java.util.List;

public record ApplicantResponse(Long id, String fullName, String email, List<ApplicationResponse> applications, List<VisitResponse> visits) {
}
