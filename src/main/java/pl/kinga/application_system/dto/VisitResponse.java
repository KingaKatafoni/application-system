package pl.kinga.application_system.dto;

import pl.kinga.application_system.model.Applicant;

import java.time.LocalDate;

public record VisitResponse(Long id, LocalDate visitDate, String purpose, String status, String applicantName) {
}
