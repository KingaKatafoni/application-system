package pl.kinga.application_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kinga.application_system.dto.ApplicantRequest;
import pl.kinga.application_system.dto.ApplicantResponse;
import pl.kinga.application_system.dto.ApplicationRequest;
import pl.kinga.application_system.dto.DtoMapper;
import pl.kinga.application_system.model.Applicant;
import pl.kinga.application_system.service.ApplicantService;
import pl.kinga.application_system.util.RequestIdGenerator;

import java.util.List;

@RestController
public class ApplicantController {
    private final ApplicantService service;
    private final DtoMapper mapper;
    private final RequestIdGenerator idGenerator;

    public ApplicantController(ApplicantService service, DtoMapper mapper, RequestIdGenerator idGenerator) {
        this.service = service;
        this.mapper = mapper;
        this.idGenerator = idGenerator;
    }

    @GetMapping("/applicants")
    public List<ApplicantResponse> getAll() {
        System.out.println("Id ApplicantController:" + idGenerator.getRequestId());
        return service.getAllApplicants().stream()
                .map(mapper::toApplicantResponse)
                .toList();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<ApplicantResponse> getById(@PathVariable Long id) {
        return service.getApplicantById(id)
                .map(mapper::toApplicantResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/applicants")
    public ResponseEntity<ApplicantResponse> create(@Valid @RequestBody ApplicantRequest request) {
        Applicant applicant = mapper.toApplicant(request);
        Applicant saved = service.createApplicant(applicant);
        return ResponseEntity.status(201).body(mapper.toApplicantResponse(saved));
    }

    @PostMapping("/applicants/{id}/applications")
    public ResponseEntity<ApplicantResponse> addApplication(@PathVariable Long id, @Valid @RequestBody ApplicationRequest request) {
        Applicant updated = service.addApplicationToApplicant(id, mapper.toApplication(request));
        return ResponseEntity.status(201).body(mapper.toApplicantResponse(updated));
    }
}
