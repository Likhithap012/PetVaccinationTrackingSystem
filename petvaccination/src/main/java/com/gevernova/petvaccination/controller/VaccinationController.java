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
    public ResponseEntity<Pet> create(@Valid @RequestBody RequestDTO requestDTO){
        return ResponseEntity.ok(petService.create(petService.mapToPet(requestDTO)));
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getById(@PathVariable long id) {
        return ResponseEntity.ok(vaccinationRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found")));
    }

    @GetMapping("/pets/all")
    public ResponseEntity<List<Pet>> getAllPets(){
        return ResponseEntity.ok(petService.getAllpets());
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable long id,@Valid @RequestBody RequestDTO requestDTO){
        return ResponseEntity.ok(petService.maptoResponse(petService.updateById(id,requestDTO)));
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        petService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
