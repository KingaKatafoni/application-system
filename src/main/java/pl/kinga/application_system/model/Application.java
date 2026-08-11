package pl.kinga.application_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Typ wniosku nie moze byc pusty")
    private String type;

    @NotBlank(message = "Status nie moze byc pusty")
    private String status;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    @JsonBackReference
    private Applicant applicant;

    public Application(){}

    public Application(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
