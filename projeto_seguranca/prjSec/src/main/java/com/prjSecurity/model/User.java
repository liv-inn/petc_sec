package com.prjSecurity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Login é obrigatório")
    @Size(min = 3, max = 50, message = "Login deve ter entre 3 e 50 caracteres")
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    @Column(name = "senha", nullable = false)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusUser status = StatusUser.ATIVO;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @Column(name = "ultimo_acesso")
    private LocalDateTime ultimoAcesso;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }
    
    // Enum for user status
    public enum StatusUser {
        ATIVO, INATIVO
    }
    
    // Constructors
    public User() {}
    
    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public StatusUser getStatus() {
        return status;
    }
    
    public void setStatus(StatusUser status) {
        this.status = status;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }
    
    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
}
