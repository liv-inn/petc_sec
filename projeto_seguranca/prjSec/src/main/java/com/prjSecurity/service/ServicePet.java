package com.prjSecurity.service;

import com.prjSecurity.model.Pet;
import com.prjSecurity.repository.RepoPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicePet {
    @Autowired
    private RepoPet petRepository;
    
    public List<Pet> findAll() {
        return petRepository.findAll();
    }
    
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }
    
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }
    
    public Pet update(Long id, Pet petAtualizado) {
        return petRepository.findById(id)
            .map(pet -> {
                pet.setNome(petAtualizado.getNome());
                pet.setEspecie(petAtualizado.getEspecie());
                pet.setRaca(petAtualizado.getRaca());
                pet.setIdade(petAtualizado.getIdade());
                pet.setDono(petAtualizado.getDono());
                return petRepository.save(pet);
            })
            .orElseThrow(() -> new RuntimeException("Pet não encontrado com ID: " + id));
    }
    
    public void deleteById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Pet não encontrado com ID: " + id);
        }
        petRepository.deleteById(id);
    }
    
    public List<Pet> findByNome(String nome) {
        return petRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Pet> findByEspecie(String especie) {
        return petRepository.findByEspecieIgnoreCase(especie);
    }
    
    public List<Pet> findByDonoId(Long donoId) {
        return petRepository.findByDonoId(donoId);
    }
    
    public Long countTotal() {
        return petRepository.countTotalPets();
    }
    
    public List<Object[]> countByEspecie() {
        return petRepository.countPetsByEspecie();
    }
}
