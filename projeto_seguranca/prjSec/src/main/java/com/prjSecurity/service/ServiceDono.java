package com.prjSecurity.service;

import com.prjSecurity.model.Dono;
import com.prjSecurity.repository.RepoDono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceDono {
    @Autowired
    private RepoDono donoRepository;
    
    public List<Dono> findAll() {
        return donoRepository.findAll();
    }
    
    public Optional<Dono> findById(Long id) {
        return donoRepository.findById(id);
    }
    
    public Dono save(Dono dono) {
        return donoRepository.save(dono);
    }
    
    public Dono update(Long id, Dono donoAtualizado) {
        return donoRepository.findById(id)
            .map(dono -> {
                dono.setNome(donoAtualizado.getNome());
                dono.setCelular(donoAtualizado.getCelular());
                return donoRepository.save(dono);
            })
            .orElseThrow(() -> new RuntimeException("Dono não encontrado com ID: " + id));
    }
    
    public void deleteById(Long id) {
        if (!donoRepository.existsById(id)) {
            throw new RuntimeException("Dono não encontrado com ID: " + id);
        }
        donoRepository.deleteById(id);
    }
    
    public List<Dono> findByNome(String nome) {
        return donoRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public Optional<Dono> findByCelular(String celular) {
        return donoRepository.findByCelular(celular);
    }
    
    public Long countTotal() {
        return donoRepository.countTotalDonos();
    }
    
    public List<Dono> findAllWithPets() {
        return donoRepository.findAllWithPets();
    }
}
