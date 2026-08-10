package pl.kinga.application_system.service;

import org.springframework.stereotype.Service;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public  ApplicationService(ApplicationRepository repository){
        this.applicationRepository = repository;
    }

    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id){
        return applicationRepository.findById(id);
    }

    public List<Application> getApplicationsByType(String type){
        return applicationRepository.findByType(type);
    }

    public Application createApplication(Application application){
        return applicationRepository.save(application);
    }

    public boolean deleteApplication(Long id){
        return applicationRepository.deleteById(id);
    }

    public Application updateApplication(Long id, Application application){
        return applicationRepository.update(id, application);
    }

}
