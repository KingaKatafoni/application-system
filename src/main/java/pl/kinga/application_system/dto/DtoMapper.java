package pl.kinga.application_system.dto;

import org.springframework.stereotype.Component;
import pl.kinga.application_system.model.Applicant;
import pl.kinga.application_system.model.Application;

import java.util.List;

@Component
public class DtoMapper {

    public ApplicantResponse toApplicantResponse(Applicant applicant) {
        List<ApplicationResponse> apps = applicant.getApplications().stream()
                .map(this::toApplicationResponse)
                .toList();

        return new ApplicantResponse(
                applicant.getId(),
                applicant.getFirstName() + " " + applicant.getLastName(),
                applicant.getEmail(),
                apps
        );
    }

    public ApplicationResponse toApplicationResponse(Application application) {
        String applicantName = null;
        if (application.getApplicant() != null) {
            applicantName = application.getApplicant().getFirstName()
                    + " "
                    + application.getApplicant().getLastName();
        }

        return new ApplicationResponse(
                application.getId(),
                application.getType(),
                application.getStatus(),
                applicantName
        );
    }

    public Applicant toApplicant(ApplicantRequest request) {
        return new Applicant(
                request.firstName(),
                request.lastName(),
                request.email()
        );
    }

    public Application toApplication(ApplicationRequest request) {
        return new Application(
                request.type(),
                request.status()
        );
    }

}
