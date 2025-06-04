package com.prjSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable()) // Consider enabling CSRF protection if applicable
            .headers(headers -> headers
                .contentSecurityPolicy("default-src 'self'")
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin())
                .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000))
            )
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/dashboard/**").authenticated()
                .requestMatchers("/api/pets/**").authenticated()
                .requestMatchers("/api/donos/**").authenticated()
                .requestMatchers("/api/consultas/**").authenticated()
                .requestMatchers("/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/", "/index.html", "/login").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(httpBasic -> {})
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .permitAll()
            );
        
        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Restrict allowed origins to trusted domains only
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000", "https://yourdomain.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
