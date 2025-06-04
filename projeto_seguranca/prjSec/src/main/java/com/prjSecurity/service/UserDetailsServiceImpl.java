

package com.prjSecurity.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prjSecurity.model.User;
import com.prjSecurity.repository.RepoUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RepoUser repoUser;

    public UserDetailsServiceImpl(RepoUser repoUser) {
        this.repoUser = repoUser;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repoUser.findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getSenha(),  // senha já criptografada no banco
            user.getStatus() == User.StatusUser.ATIVO,  // usuário ativo
            true,  // accountNonExpired
            true,  // credentialsNonExpired
            true,  // accountNonLocked
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // autoridade padrão
        );
    }
}
