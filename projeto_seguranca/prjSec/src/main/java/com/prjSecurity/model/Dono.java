package com.prjSecurity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "donos")
public class Dono {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome do dono é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato do celular deve ser (XX) XXXXX-XXXX")
    @Column(name = "celular")
    private String celular;
    
    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }
    
    // Constructors
    public Dono() {}
    
    public Dono(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public List<Pet> getPets() {
        return pets;
    }
    
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
