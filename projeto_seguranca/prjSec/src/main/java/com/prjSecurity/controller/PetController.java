package com.prjSecurity.controller;

import com.prjSecurity.model.Pet;
import com.prjSecurity.service.ServicePet;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
// Restrict CORS to trusted origins only
@CrossOrigin(origins = {"http://localhost:3000", "https://yourdomain.com"})
public class PetController {
    @Autowired
    private ServicePet petService;
    
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.findAll();
        return ResponseEntity.ok(pets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findById(id);
        return pet.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> createPet(@Valid @RequestBody Pet pet) {
        try {
            Pet novoPet = petService.save(pet);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Long id, @Valid @RequestBody Pet pet) {
        try {
            Pet petAtualizado = petService.update(id, pet);
            return ResponseEntity.ok(petAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        try {
            petService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Pet>> buscarPets(@RequestParam(required = false) String nome,
                                               @RequestParam(required = false) String especie) {
        List<Pet> pets;
        
        if (nome != null && !nome.isEmpty()) {
            pets = petService.findByNome(nome);
        } else if (especie != null && !especie.isEmpty()) {
            pets = petService.findByEspecie(especie);
        } else {
            pets = petService.findAll();
        }
        
        return ResponseEntity.ok(pets);
    }
    
    @GetMapping("/dono/{donoId}")
    public ResponseEntity<List<Pet>> getPetsByDono(@PathVariable Long donoId) {
        List<Pet> pets = petService.findByDonoId(donoId);
        return ResponseEntity.ok(pets);
    }
    
    @GetMapping("/count")
    public ResponseEntity<Long> countPets() {
        Long total = petService.countTotal();
        return ResponseEntity.ok(total);
    }
    
    @GetMapping("/estatisticas/especies")
    public ResponseEntity<List<Object[]>> getEstatisticasPorEspecie() {
        List<Object[]> estatisticas = petService.countByEspecie();
        return ResponseEntity.ok(estatisticas);
    }
}
