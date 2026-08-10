package pl.kinga.application_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
    public Application getById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @GetMapping("/applications/type/{type}")
    public List<Application> getByType(@PathVariable String type) {
        return service.getApplicationsByType(type);
    }
}
