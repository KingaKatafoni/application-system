package pl.kinga.application_system.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import pl.kinga.application_system.model.Applicant;
import pl.kinga.application_system.model.Application;
import pl.kinga.application_system.repository.ApplicantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
  private final ApplicantRepository applicantRepository;

  public ApplicantService(ApplicantRepository applicantRepository){
      this.applicantRepository = applicantRepository;
  }

  @PostConstruct
  public void init(){
      System.out.println("Service is already started!");
      System.out.println("Amount of Applicants: " + applicantRepository.count());
  }

  @PreDestroy
  public void cleanUp(){
      System.out.println("Service is shutting down!");
  }

  public List<Applicant> getAllApplicants(){
      return applicantRepository.findAll();
  }

  public Optional<Applicant> getApplicantById(Long id){
      return applicantRepository.findById(id);
  }

  public Applicant createApplicant(Applicant applicant){
      return applicantRepository.save(applicant);
  }

  public Applicant addApplicationToApplicant(Long applicantId, Application application){
      Applicant applicant = applicantRepository.findById(applicantId)
              .orElseThrow(() -> new RuntimeException("Nie znaleziono wnioskodawcy o id: " + applicantId));
      application.setApplicant(applicant);
      applicant.getApplications().add(application);
      return applicantRepository.save(applicant);
  }
}
