package com.prjSecurity.repository;

import com.prjSecurity.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

public interface RepoConsulta extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPetId(Long petId);
    
    List<Consulta> findByDataConsultaBetween(LocalDateTime inicio, LocalDateTime fim);
    
    @Query("SELECT c FROM Consulta c WHERE c.pet.id = :petId ORDER BY c.dataConsulta DESC")
    List<Consulta> findByPetIdOrderByDataConsultaDesc(@Param("petId") Long petId);
    
    @Query("SELECT COUNT(c) FROM Consulta c")
    Long countTotalConsultas();
    
    @Query("SELECT c FROM Consulta c WHERE c.pet.dono.id = :donoId ORDER BY c.dataConsulta DESC")
    List<Consulta> findByDonoIdOrderByDataConsultaDesc(@Param("donoId") Long donoId);
    
    @Query("SELECT c FROM Consulta c ORDER BY c.dataConsulta DESC")
    List<Consulta> findAllOrderByDataConsultaDesc();
}
