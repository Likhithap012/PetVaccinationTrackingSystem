package com.gevernova.petvaccination.entity;

import jakarta.persistence.*;
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
@Entity
@Builder
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerContact;

    @Column(nullable = false)
    @ElementCollection//Creates table in db to hold values of vaccination
    //collectiontable is used to explicitly name the table and tells how to link the main entity (Pet) to the collection table (pet_vaccinations).
    @CollectionTable(name="pet_vaccinations",joinColumns = @JoinColumn(name="pet_id"))
    private List<Vaccination> vaccinations;
}
