package pl.kinga.application_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.application_system.model.Applicant;

public interface ApplicantRepository  extends JpaRepository<Applicant, Long> {

}
