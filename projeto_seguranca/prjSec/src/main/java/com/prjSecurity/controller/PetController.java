package com.prjSecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjSecurity.model.Dono;
import com.prjSecurity.model.Pet;
import com.prjSecurity.repository.RepoDono;
import com.prjSecurity.service.ServicePet;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private ServicePet petService;

    @Autowired
    private RepoDono donoRepository;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPet(@RequestBody Pet pet) {
        if (pet.getDono() == null || pet.getDono().getId() == null) {
            return ResponseEntity.badRequest().body("Dono ID must be provided");
        }
        Optional<Dono> dono = donoRepository.findById(pet.getDono().getId());
        if (!dono.isPresent()) {
            return ResponseEntity.badRequest().body("Dono with ID " + pet.getDono().getId() + " does not exist");
        }
        pet.setDono(dono.get());
        Pet savedPet = petService.save(pet);
        return ResponseEntity.ok(savedPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        if (pet.getDono() == null || pet.getDono().getId() == null) {
            return ResponseEntity.badRequest().body("Dono ID must be provided");
        }
        Optional<Dono> dono = donoRepository.findById(pet.getDono().getId());
        if (!dono.isPresent()) {
            return ResponseEntity.badRequest().body("Dono with ID " + pet.getDono().getId() + " does not exist");
        }
        pet.setDono(dono.get());
        try {
            Pet updatedPet = petService.update(id, pet);
            return ResponseEntity.ok(updatedPet);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        try {
            petService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
