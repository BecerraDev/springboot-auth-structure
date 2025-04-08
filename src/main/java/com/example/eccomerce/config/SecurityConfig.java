package com.example.eccomerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.eccomerce.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authProvider;
	
    // Configuración de seguridad para las rutas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
        		.authorizeHttpRequests(authrequest -> authrequest
        		.requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui/index.html").permitAll()
        		.requestMatchers("/auth/**").permitAll() // Permitir acceso sin autenticación al login
        		.requestMatchers("/error").permitAll()
                .anyRequest().authenticated()                
                ) 
        		.sessionManagement(sessionManager-> 
        			sessionManager
        			.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        		.authenticationProvider(authProvider)
        		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        		.build();
        		
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html"); // Rutas de Swagger
    }
    
}
