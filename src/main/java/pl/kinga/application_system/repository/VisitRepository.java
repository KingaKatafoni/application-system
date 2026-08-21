package pl.kinga.application_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.application_system.model.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByVisitDate(LocalDate visitDate);
}
