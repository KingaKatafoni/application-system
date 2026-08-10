package pl.kinga.application_system.model;

public class Application {
    private Long id;
    private String applicantName;
    private String type;
    private String status;

    public Application(Long id, String applicantName, String type, String status) {
        this.id = id;
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
}
