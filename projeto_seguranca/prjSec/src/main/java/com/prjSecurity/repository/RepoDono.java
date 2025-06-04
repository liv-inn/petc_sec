package com.prjSecurity.repository;

import com.prjSecurity.model.Dono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepoDono extends JpaRepository<Dono, Long> {

    List<Dono> findByNomeContainingIgnoreCase(String nome);
    
    Optional<Dono> findByCelular(String celular);
    
    @Query("SELECT COUNT(d) FROM Dono d")
    Long countTotalDonos();
    
    @Query("SELECT d FROM Dono d LEFT JOIN FETCH d.pets")
    List<Dono> findAllWithPets();
}
