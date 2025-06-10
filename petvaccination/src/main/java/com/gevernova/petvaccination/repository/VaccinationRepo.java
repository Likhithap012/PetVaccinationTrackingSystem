package com.gevernova.petvaccination.repository;

import com.gevernova.petvaccination.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepo extends JpaRepository<Pet,Long> {

    List<Pet> findByVaccinationsName(String name);
}
