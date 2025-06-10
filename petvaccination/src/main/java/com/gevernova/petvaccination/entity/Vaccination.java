package com.gevernova.petvaccination.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Vaccination {

    private String name;

    @PastOrPresent(message = "Date given cannot be in the future")
    private LocalDate dateGiven;
}
