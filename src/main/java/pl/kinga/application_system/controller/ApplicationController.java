package pl.kinga.application_system.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kinga.application_system.dto.ApplicationRequest;
import pl.kinga.application_system.dto.ApplicationResponse;
import pl.kinga.application_system.dto.DtoMapper;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.service.ApplicationService;
import pl.kinga.application_system.util.RequestIdGenerator;

import java.util.List;

@RestController
public class ApplicationController {
    private final ApplicationService service;
    private final DtoMapper mapper;
    private final RequestIdGenerator idGenerator;

    public ApplicationController(ApplicationService service, DtoMapper mapper, RequestIdGenerator idGenerator) {
        this.service = service;
        this.mapper = mapper;
        this.idGenerator = idGenerator;
    }

    @GetMapping("/applications")
    public List<ApplicationResponse> getAll() {
        System.out.println("Id ApplicationController:" + idGenerator.getRequestId());
        return service.getAllApplications().stream()
                .map(mapper::toApplicationResponse)
                .toList();
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponse> getById(@PathVariable Long id){
       return service.getApplicationById(id)
               .map(mapper::toApplicationResponse)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/applications/type/{type}")
    public List<ApplicationResponse> getByType(@PathVariable String type) {
        return service.getApplicationsByType(type).stream()
                .map(mapper::toApplicationResponse)
                .toList();
    }

    @GetMapping("/applications/status/{status}")
    public List<ApplicationResponse> getByStatus(@PathVariable String status){
        return service.getApplicationsByStatus(status).stream()
                .map(mapper::toApplicationResponse)
                .toList();
    }

    @PostMapping("/applications")
    public ResponseEntity<ApplicationResponse> create(@Valid @RequestBody ApplicationRequest request) {
        Application app = mapper.toApplication(request);
        Application saved = service.createApplication(app);
        return ResponseEntity.status(201).body(mapper.toApplicationResponse(saved));
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponse> update(@PathVariable Long id,
                                              @Valid @RequestBody ApplicationRequest request) {

        Application application = new Application(request.type(), request.status());
        return service.updateApplication(id, application)
                .map(mapper::toApplicationResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       if(service.getApplicationById(id).isEmpty()){
           return ResponseEntity.notFound().build();
       }
       service.deleteApplication(id);
       return ResponseEntity.noContent().build();
    }

}
