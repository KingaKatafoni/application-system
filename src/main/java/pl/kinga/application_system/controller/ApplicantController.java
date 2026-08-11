package pl.kinga.application_system.controller;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kinga.application_system.model.Applicant;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.service.ApplicantService;

import java.util.List;

@RestController
public class ApplicantController {
    private final ApplicantService service;

    public ApplicantController(ApplicantService service){
        this.service = service;
    }

    @GetMapping("/applicants")
    public List<Applicant> getAll(){
        return service.getAllApplicants();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<Applicant> getById(@PathVariable Long id){
        return service.getApplicantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/applicants")
    public ResponseEntity<Applicant> create(@Valid @RequestBody Applicant applicant){
        Applicant saved = service.createApplicant(applicant);
        return ResponseEntity.status(201).body(saved);
    }

    @PostMapping("/applicants/{id}/applications")
    public ResponseEntity<Applicant> addApplication(@PathVariable Long id, @Valid @RequestBody Application application){
        Applicant uppdated = service.addApplicationToApplicant(id, application);
        return ResponseEntity.status(201).body(uppdated);
    }
}
