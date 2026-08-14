package pl.kinga.application_system.health;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import pl.kinga.application_system.repository.ApplicantRepository;

@Component
public class ApplicantHealthIndicator implements HealthIndicator {
    private final ApplicantRepository repository;

    public ApplicantHealthIndicator(ApplicantRepository repository){
        this.repository =repository;
    }


    @Override
    public Health health() {
        long count = repository.count();
        if(count > 0) {
            return Health.up()
                    .withDetail("applicants", count)
                    .withDetail("message", "System has applicants")
                    .build();
        }
        return Health.up()
                .withDetail("applicants", 0)
                .withDetail("message", "No applicants yet")
                .build();
    }
}
