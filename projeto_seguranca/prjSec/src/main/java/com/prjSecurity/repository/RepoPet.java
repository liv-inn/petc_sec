package com.prjSecurity.repository;

import com.prjSecurity.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepoPet extends JpaRepository<Pet, Long> {
    List<Pet> findByNomeContainingIgnoreCase(String nome);
    
    List<Pet> findByEspecieIgnoreCase(String especie);
    
    List<Pet> findByDonoId(Long donoId);
    
    @Query("SELECT p FROM Pet p WHERE p.dono.nome LIKE %:nomeDono%")
    List<Pet> findByDonoNomeContaining(@Param("nomeDono") String nomeDono);
    
    @Query("SELECT COUNT(p) FROM Pet p")
    Long countTotalPets();
    
    @Query("SELECT p.especie, COUNT(p) FROM Pet p GROUP BY p.especie")
    List<Object[]> countPetsByEspecie();
}
