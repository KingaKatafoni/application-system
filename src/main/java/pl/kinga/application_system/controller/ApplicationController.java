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
        Application app = service.getApplicationById(id);
        if(app == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(app);
    }

    @GetMapping("/applications/type/{type}")
    public List<Application> getByType(@PathVariable String type) {
        return service.getApplicationsByType(type);
    }

    @PostMapping("/applications")
    public ResponseEntity<Application> create(@Valid @RequestBody Application application) {
        Application saved = service.createApplication(application);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<Application> update(@PathVariable Long id,
                                              @Valid @RequestBody Application application) {
        Application updated = service.updateApplication(id, application);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleted = service.deleteApplication(id);
        if(deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
