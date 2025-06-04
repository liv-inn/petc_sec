package com.prjSecurity.controller;

import com.prjSecurity.model.Consulta;
import com.prjSecurity.service.ServiceConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {
    @Autowired
    private ServiceConsulta serviceConsulta;
    
    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() {
        List<Consulta> consultas = serviceConsulta.findAll();
        return ResponseEntity.ok(consultas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        Optional<Consulta> consulta = serviceConsulta.findById(id);
        return consulta.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@Valid @RequestBody Consulta consulta) {
        try {
            Consulta novaConsulta = serviceConsulta.save(consulta);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @Valid @RequestBody Consulta consulta) {
        try {
            Consulta consultaAtualizada = serviceConsulta.update(id, consulta);
            return ResponseEntity.ok(consultaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        try {
            serviceConsulta.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<Consulta>> getConsultasByPet(@PathVariable Long petId) {
        List<Consulta> consultas = serviceConsulta.findByPetId(petId);
        return ResponseEntity.ok(consultas);
    }
    
    @GetMapping("/dono/{donoId}")
    public ResponseEntity<List<Consulta>> getConsultasByDono(@PathVariable Long donoId) {
        List<Consulta> consultas = serviceConsulta.findByDonoId(donoId);
        return ResponseEntity.ok(consultas);
    }
    
    @GetMapping("/periodo")
    public ResponseEntity<List<Consulta>> getConsultasByPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        List<Consulta> consultas = serviceConsulta.findByPeriodo(inicio, fim);
        return ResponseEntity.ok(consultas);
    }
    
    @GetMapping("/count")
    public ResponseEntity<Long> countConsultas() {
        Long total = serviceConsulta.countTotal();
        return ResponseEntity.ok(total);
    }
}
