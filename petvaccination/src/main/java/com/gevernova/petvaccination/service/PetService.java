package com.gevernova.petvaccination.service;

import com.gevernova.petvaccination.dto.RequestDTO;
import com.gevernova.petvaccination.dto.ResponseDTO;
import com.gevernova.petvaccination.entity.Pet;
import com.gevernova.petvaccination.repository.VaccinationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService implements PetOperations {
    private final VaccinationRepo repo;
    private PetOperations petOperations;

    public Pet mapToPet(RequestDTO requestDTO){
        return Pet.builder()
                .name(requestDTO.getName())
                .species(requestDTO.getSpecies())
                .breed(requestDTO.getBreed())
                .ownerName(requestDTO.getOwnerName())
                .vaccinations(requestDTO.getVaccinations())
                .ownerContact(requestDTO.getOwnerContact())
                .build();
    }

    public ResponseDTO maptoResponse(Pet pet){
        return ResponseDTO.builder()
                .id(pet.getId())
                .name(pet.getName())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .ownerName(pet.getOwnerName())
                .ownerContact(pet.getOwnerContact())
                .vaccinations(pet.getVaccinations())
                .build();
    }
    @Override
    public Pet create(Pet pet) {
        return repo.save(pet);
    }

    @Override
    public Pet getById(long id) {
        return repo.findById(id).orElseThrow(()->new RuntimeException("Not such id found"));
    }

    @Override
    public List<Pet> getAllpets() {
        return repo.findAll();
    }

    @Override
    public Pet updateById(long id, RequestDTO requestDTO) {
        Pet updated=getById(id);
        updated.setName(requestDTO.getName());
        updated.setSpecies(requestDTO.getSpecies());
        updated.setBreed(requestDTO.getBreed());
        updated.setVaccinations(requestDTO.getVaccinations());
        updated.setOwnerContact(requestDTO.getOwnerContact());
        updated.setOwnerName(requestDTO.getOwnerName());
        return repo.save(updated);
    }

    @Override
    public void deleteById(long id) {
        repo.delete(getById(id));
    }
}
