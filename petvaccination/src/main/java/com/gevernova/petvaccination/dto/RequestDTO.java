package com.gevernova.petvaccination.dto;

import com.gevernova.petvaccination.entity.Vaccination;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String species;

    @NotBlank
    private String breed;

    @NotBlank
    private String ownerName;

    @NotBlank(message = "Owner contact is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Owner contact must be a valid 10-digit Indian phone number"
    )
    private String ownerContact;

    @NotEmpty
    private List<Vaccination> vaccinations;

}
