package com.prjSecurity.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", nullable = false)
    @NotNull(message = "Pet é obrigatório")
    private Pet pet;
    
    @Column(name = "data_consulta", nullable = false)
    @NotNull(message = "Data da consulta é obrigatória")
    private LocalDateTime dataConsulta;
    
    @Size(max = 1000, message = "Observações devem ter no máximo 1000 caracteres")
    @Column(name = "observacoes", length = 1000)
    private String observacoes;
    
    @Size(max = 500, message = "Diagnóstico deve ter no máximo 500 caracteres")
    @Column(name = "diagnostico", length = 500)
    private String diagnostico;
    
    @Size(max = 500, message = "Tratamento deve ter no máximo 500 caracteres")
    @Column(name = "tratamento", length = 500)
    private String tratamento;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }
    
    // Constructors
    public Consulta() {}
    
    public Consulta(Pet pet, LocalDateTime dataConsulta, String observacoes) {
        this.pet = pet;
        this.dataConsulta = dataConsulta;
        this.observacoes = observacoes;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Pet getPet() {
        return pet;
    }
    
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }
    
    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public String getTratamento() {
        return tratamento;
    }
    
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
