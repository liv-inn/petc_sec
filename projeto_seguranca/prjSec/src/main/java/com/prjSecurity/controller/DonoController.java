package com.prjSecurity.controller;
import com.prjSecurity.model.Dono;
import com.prjSecurity.service.ServiceDono;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donos")
@CrossOrigin(origins = "*")
public class DonoController {
    @Autowired
    private ServiceDono donoService;
    
    @GetMapping
    public ResponseEntity<List<Dono>> getAllDonos() {
        List<Dono> donos = donoService.findAll();
        return ResponseEntity.ok(donos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Dono> getDonoById(@PathVariable Long id) {
        Optional<Dono> dono = donoService.findById(id);
        return dono.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Dono> createDono(@Valid @RequestBody Dono dono) {
        try {
            Dono novoDono = donoService.save(dono);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoDono);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Dono> updateDono(@PathVariable Long id, @Valid @RequestBody Dono dono) {
        try {
            Dono donoAtualizado = donoService.update(id, dono);
            return ResponseEntity.ok(donoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDono(@PathVariable Long id) {
        try {
            donoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Dono>> buscarDonos(@RequestParam String nome) {
        List<Dono> donos = donoService.findByNome(nome);
        return ResponseEntity.ok(donos);
    }
    
    @GetMapping("/celular/{celular}")
    public ResponseEntity<Dono> getDonoByCelular(@PathVariable String celular) {
        Optional<Dono> dono = donoService.findByCelular(celular);
        return dono.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/count")
    public ResponseEntity<Long> countDonos() {
        Long total = donoService.countTotal();
        return ResponseEntity.ok(total);
    }
    
    @GetMapping("/com-pets")
    public ResponseEntity<List<Dono>> getDonosComPets() {
        List<Dono> donos = donoService.findAllWithPets();
        return ResponseEntity.ok(donos);
    }
}
