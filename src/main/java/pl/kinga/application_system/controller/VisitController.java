package pl.kinga.application_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kinga.application_system.dto.DtoMapper;
import pl.kinga.application_system.dto.VisitRequest;
import pl.kinga.application_system.dto.VisitResponse;
import pl.kinga.application_system.model.Visit;
import pl.kinga.application_system.service.VisitService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VisitController {
    private final VisitService service;
    private final DtoMapper mapper;

    public VisitController(VisitService service, DtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/visits")
    public List<VisitResponse> getAll() {
        return service.getAllVisits().stream()
                .map(mapper::toVisitResponse)
                .toList();
    }

    @GetMapping("/visits/{id}")
    public ResponseEntity<VisitResponse> getVisitById(@PathVariable Long id) {
        return service.getVisitById(id)
                .map(mapper::toVisitResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/visits/date/{date}")
    public List<VisitResponse> getVisitByDate(@PathVariable LocalDate date) {
        return service.getVisitByDate(date).stream()
                .map(mapper::toVisitResponse)
                .toList();
    }

    @PostMapping("applicants/{applicantId}/visits")
    public ResponseEntity<VisitResponse> addVisit(@PathVariable Long applicantId, @Valid @RequestBody VisitRequest request) {
        Visit visit = service.addVisitToApplicant(applicantId, mapper.toVisit(request));
        return ResponseEntity.status(201).body(mapper.toVisitResponse(visit));
    }

}
