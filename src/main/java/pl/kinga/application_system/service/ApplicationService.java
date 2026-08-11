package pl.kinga.application_system.service;

import org.springframework.stereotype.Service;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public  ApplicationService(ApplicationRepository repository){
        this.applicationRepository = repository;
    }

    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id){
        return applicationRepository.findById(id);
    }

    public List<Application> getApplicationsByType(String type){
        return applicationRepository.findByType(type);
    }

    public List<Application> getApplicationsByStatus(String status){
        return applicationRepository.findByStatus(status);
    }

    public Application createApplication(Application application){
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id){
        applicationRepository.deleteById(id);
    }

    public Optional<Application> updateApplication(Long id, Application updated) {
        return applicationRepository.findById(id).map(existing -> {
            existing.setType(updated.getType());
            existing.setStatus(updated.getStatus());
            return applicationRepository.save(existing);
        });
    }

}
