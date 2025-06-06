package com.example.eccomerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.eccomerce.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	
	private final UsuarioRepository usuarioRepository;
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	
	{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
		
		
	}

	@Bean
	public UserDetailsService userDetailService() {
		return username -> usuarioRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("El Username:" + username));
			
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();

	}	
	
}

