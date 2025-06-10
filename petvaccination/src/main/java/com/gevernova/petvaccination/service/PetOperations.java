package com.gevernova.petvaccination.service;

import com.gevernova.petvaccination.dto.RequestDTO;
import com.gevernova.petvaccination.dto.ResponseDTO;
import com.gevernova.petvaccination.entity.Pet;

import java.util.List;

public interface PetOperations {

    public Pet create(Pet pet);
    public Pet getById(long id);
    public List<Pet> getAllpets();

    public Pet updateById(long id, RequestDTO requestDTO);

    public void deleteById(long id);

    public List<Pet> getPetsByVaccine(String vaccineName);
}
