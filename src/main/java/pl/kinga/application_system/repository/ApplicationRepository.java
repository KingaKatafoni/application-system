package pl.kinga.application_system.repository;

import org.springframework.stereotype.Repository;
import pl.kinga.application_system.model.Application;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationRepository {
    private final List<Application> applications = new ArrayList<>(List.of(
            new Application(1L, "Anna Nowak", "MELDUNEK", "NOWY"),
            new Application(2L, "Jan Kowalski", "DOWOD", "W_TRAKCIE"),
            new Application(3L, "Maria Wisniewska", "MELDUNEK", "ZAKONCZONY")
    ));

    private Long nextId = 4L;

    public List<Application> findAll(){
        return applications;
    }

   public Application findById(Long id){
        return applications.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
   }

   public List<Application> findByType(String type){
       return applications.stream()
                .filter(a -> a.getType().equals(type))
                .toList();
   }

   public Application save(Application application){
        application.setId(nextId++);
        applications.add(application);
        return application;
   }

   public boolean deleteById(Long id){
        return applications.removeIf(a -> a.getId().equals(id));
   }

   public Application update(Long id, Application updated){
        Application existing = findById(id);
        if(existing == null){
            return null;
        }
        existing.setApplicantName(updated.getApplicantName());
        existing.setType(updated.getType());
        existing.setStatus(updated.getStatus());
        return existing;
   }
}
