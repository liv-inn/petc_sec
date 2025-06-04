package com.prjSecurity.service;

import com.prjSecurity.model.Consulta;
import com.prjSecurity.repository.RepoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceConsulta {
    @Autowired
    private RepoConsulta consultaRepository;
    
    public List<Consulta> findAll() {
        return consultaRepository.findAllOrderByDataConsultaDesc();
    }
    
    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }
    
    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }
    
    public Consulta update(Long id, Consulta consultaAtualizada) {
        return consultaRepository.findById(id)
            .map(consulta -> {
                consulta.setDataConsulta(consultaAtualizada.getDataConsulta());
                consulta.setObservacoes(consultaAtualizada.getObservacoes());
                consulta.setDiagnostico(consultaAtualizada.getDiagnostico());
                consulta.setTratamento(consultaAtualizada.getTratamento());
                return consultaRepository.save(consulta);
            })
            .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
    }
    
    public void deleteById(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new RuntimeException("Consulta não encontrada com ID: " + id);
        }
        consultaRepository.deleteById(id);
    }
    
    public List<Consulta> findByPetId(Long petId) {
        return consultaRepository.findByPetIdOrderByDataConsultaDesc(petId);
    }
    
    public List<Consulta> findByDonoId(Long donoId) {
        return consultaRepository.findByDonoIdOrderByDataConsultaDesc(donoId);
    }
    
    public List<Consulta> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return consultaRepository.findByDataConsultaBetween(inicio, fim);
    }
    
    public Long countTotal() {
        return consultaRepository.countTotalConsultas();
    }
}
