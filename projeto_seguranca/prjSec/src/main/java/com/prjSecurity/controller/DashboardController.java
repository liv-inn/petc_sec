package com.prjSecurity.controller;
import com.prjSecurity.service.ServicePet;
import com.prjSecurity.service.ServiceDono;
import com.prjSecurity.service.ServiceConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    
    @Autowired
    private ServicePet petService;
    
    @Autowired
    private ServiceDono donoService;
    
    @Autowired
    private ServiceConsulta consultaService;
    
    @GetMapping("/estatisticas")
    public ResponseEntity<Map<String, Object>> getEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        
        // Totais principais
        estatisticas.put("totalPets", petService.countTotal());
        estatisticas.put("totalDonos", donoService.countTotal());
        estatisticas.put("totalConsultas", consultaService.countTotal());
        
        // Estatísticas por espécie
        estatisticas.put("petsPorEspecie", petService.countByEspecie());
        
        return ResponseEntity.ok(estatisticas);
    }
    
    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Long>> getResumo() {
        Map<String, Long> resumo = new HashMap<>();
        
        resumo.put("pets", petService.countTotal());
        resumo.put("donos", donoService.countTotal());
        resumo.put("consultas", consultaService.countTotal());
        
        return ResponseEntity.ok(resumo);
    }
}
