package com.gevernova.petvaccination.dto;

import com.gevernova.petvaccination.entity.Vaccination;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {

    private long id;

    private String name;

    private String species;

    private String breed;

    private String ownerName;

    private String ownerContact;

    private List<Vaccination> vaccinations;
}
