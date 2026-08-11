package pl.kinga.application_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Imie wnioskodawcy nie moze byc puste")
    @Size(min = 2, max = 100, message = "Imie musi miec od 2 do 100 znakow")
    private String applicantName;

    @NotBlank(message = "Typ wniosku nie moze byc pusty")
    private String type;

    @NotBlank(message = "Status nie moze byc pusty")
    private String status;

    public Application(){}

    public Application(String applicantName, String type, String status) {
        this.applicantName = applicantName;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getApplicantName() {
        return applicantName;
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

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setType(String type) {
        this.type = type;
    }
}
