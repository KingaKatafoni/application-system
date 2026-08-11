package pl.kinga.application_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.application_system.model.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByType(String type);

    List<Application> findByStatus(String status);

}
