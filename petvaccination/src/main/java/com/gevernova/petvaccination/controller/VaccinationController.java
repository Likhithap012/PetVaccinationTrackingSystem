package com.gevernova.petvaccination.controller;

import com.gevernova.petvaccination.dto.RequestDTO;
import com.gevernova.petvaccination.dto.ResponseDTO;
import com.gevernova.petvaccination.entity.Pet;
import com.gevernova.petvaccination.repository.VaccinationRepo;
import com.gevernova.petvaccination.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VaccinationController {

    private final PetService petService;

    private final VaccinationRepo vaccinationRepo;

    @PostMapping("/pets")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody RequestDTO requestDTO){
        return ResponseEntity.ok(petService.maptoResponse(petService.create(petService.mapToPet(requestDTO))));
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id) {
        Pet pet = vaccinationRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found"));
        ResponseDTO responseDTO = petService.maptoResponse(pet);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/pets/all")
    public ResponseEntity<List<ResponseDTO>> getAllPets(){
        List<Pet> pets = petService.getAllpets();
        List<ResponseDTO> responseDTOs = pets.stream()
                .map(petService::maptoResponse)
                .toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable long id,@Valid @RequestBody RequestDTO requestDTO){
        return ResponseEntity.ok(petService.maptoResponse(petService.updateById(id,requestDTO)));
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        petService.deleteById(id);
        return ResponseEntity.ok("Pet with Id "+id+" has been deleted successfully");
    }
}
