package pl.kinga.application_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.service.ApplicationService;

import java.util.List;

@RestController
public class ApplicationController {
    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/applications")
    public List<Application> getAll() {
        return service.getAllApplications();
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getById(@PathVariable Long id){
       return service.getApplicationById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/applications/type/{type}")
    public List<Application> getByType(@PathVariable String type) {
        return service.getApplicationsByType(type);
    }

    @GetMapping("/applications/status/{status}")
    public List<Application> getByStatus(@PathVariable String status){
        return service.getApplicationsByStatus(status);
    }

    @PostMapping("/applications")
    public ResponseEntity<Application> create(@Valid @RequestBody Application application) {
        Application saved = service.createApplication(application);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<Application> update(@PathVariable Long id,
                                              @Valid @RequestBody Application application) {
        return service.updateApplication(id, application)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       if(!service.getAllApplications().stream()
               .anyMatch(a-> a.getId().equals(id))){
           return ResponseEntity.notFound().build();
       }
       service.deleteApplication(id);
       return ResponseEntity.noContent().build();
    }

}
