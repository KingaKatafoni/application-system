package pl.kinga.application_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VisitRequest(

        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "Date cannot be empty")
        @Future
        LocalDate visitDate,

        @NotBlank(message = "Purpose cannot be empty")
        String purpose,

        @NotBlank(message = "Status cannot be empty")
        String status) {
}
