package com.prjSecurity.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prjSecurity.model.Dono;
import com.prjSecurity.model.Pet;
import com.prjSecurity.model.User;
import com.prjSecurity.repository.RepoUser;
import com.prjSecurity.service.ServiceDono;
import com.prjSecurity.service.ServicePet;

@Configuration
public class DataInitConfig {

    @Bean
    public CommandLineRunner initUsers(RepoUser repoUser, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!repoUser.existsByLogin("admin")) {
                String rawPassword = "admin123";  
                String encodedPassword = passwordEncoder.encode(rawPassword);  

                User admin = new User();
                admin.setLogin("admin");
                admin.setSenha(encodedPassword); 
                admin.setStatus(User.StatusUser.ATIVO);

                repoUser.save(admin);

                System.out.println("Usuário admin criado com senha: " + rawPassword);
            }
        };
    }

    @Bean
    public CommandLineRunner initData(ServiceDono donoService, ServicePet petService) {
        return args -> {
            if (donoService.countTotal() == 0) {
                Dono dono1 = new Dono();
                dono1.setNome("João Silva");
                dono1.setCelular("(11) 99999-9999");
                donoService.save(dono1);

                Dono dono2 = new Dono();
                dono2.setNome("Maria Oliveira");
                dono2.setCelular("(21) 98888-8888");
                donoService.save(dono2);

                Dono dono3 = new Dono();
                dono3.setNome("Carlos Pereira");
                dono3.setCelular("(31) 97777-7777");
                donoService.save(dono3);

                Dono dono4 = new Dono();
                dono4.setNome("Ana Souza");
                dono4.setCelular("(41) 96666-6666");
                donoService.save(dono4);

                Dono dono5 = new Dono();
                dono5.setNome("Paula Lima");
                dono5.setCelular("(51) 95555-5555");
                donoService.save(dono5);

                Pet pet1 = new Pet();
                pet1.setNome("Rex");
                pet1.setEspecie("Cachorro");
                pet1.setRaca("Pastor Alemão");
                pet1.setIdade(5);
                pet1.setDono(dono1);
                petService.save(pet1);

                Pet pet2 = new Pet();
                pet2.setNome("Mimi");
                pet2.setEspecie("Gato");
                pet2.setRaca("Siamês");
                pet2.setIdade(3);
                pet2.setDono(dono2);
                petService.save(pet2);

                Pet pet3 = new Pet();
                pet3.setNome("Toby");
                pet3.setEspecie("Cachorro");
                pet3.setRaca("Beagle");
                pet3.setIdade(4);
                pet3.setDono(dono3);
                petService.save(pet3);

                Pet pet4 = new Pet();
                pet4.setNome("Luna");
                pet4.setEspecie("Gato");
                pet4.setRaca("Maine Coon");
                pet4.setIdade(2);
                pet4.setDono(dono4);
                petService.save(pet4);

                Pet pet5 = new Pet();
                pet5.setNome("Max");
                pet5.setEspecie("Cachorro");
                pet5.setRaca("Bulldog");
                pet5.setIdade(6);
                pet5.setDono(dono5);
                petService.save(pet5);

                System.out.println("Dados iniciais de Donos e Pets criados.");
            }
        };
    }
}
