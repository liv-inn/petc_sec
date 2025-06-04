package com.prjSecurity.repository;
import com.prjSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepoUser extends JpaRepository<User, Long> {
        
    Optional<User> findByLogin(String login);
    
    boolean existsByLogin(String login);
}
