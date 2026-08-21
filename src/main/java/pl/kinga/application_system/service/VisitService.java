package pl.kinga.application_system.service;

import org.springframework.stereotype.Service;
import pl.kinga.application_system.model.Applicant;
import pl.kinga.application_system.model.Visit;
import pl.kinga.application_system.repository.ApplicantRepository;
import pl.kinga.application_system.repository.VisitRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final ApplicantRepository applicantRepository;

    public VisitService(VisitRepository visitRepository, ApplicantRepository applicantRepository) {
        this.visitRepository = visitRepository;
        this.applicantRepository = applicantRepository;
    }

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisitById(Long id) {
        return visitRepository.findById(id);
    }

    public List<Visit> getVisitByDate(LocalDate visitDate) {
        return visitRepository.findByVisitDate(visitDate);
    }

    public Visit addVisitToApplicant(Long applicantId, Visit visit) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono wnioskodawcy o id: " + applicantId));
        visit.setApplicant(applicant);
        applicant.getVisits().add(visit);
        return visitRepository.save(visit);
    }


}
