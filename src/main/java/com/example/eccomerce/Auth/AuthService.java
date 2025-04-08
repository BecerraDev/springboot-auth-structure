package com.example.eccomerce.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;

import com.example.eccomerce.entity.Role;
import com.example.eccomerce.entity.Usuario;
import com.example.eccomerce.jwt.JwtService;
import com.example.eccomerce.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final UsuarioRepository usuarioRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
		return AuthResponse.builder()
				.token(token)
				.build();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse register (RegisterRequest request) {


				Usuario usuario = Usuario.builder()
						.username(request.getUsername())
						.password(passwordEncoder.encode(request.getPassword()))
						.lastname(request.getLastname())
						.firstname(request.getFirstname())
						.email(request.getEmail())
						.country(request.getCountry())
						.role(Role.NORMAL)
						.build();
			
			usuarioRepository.save(usuario);
			
			return AuthResponse.builder()
					.token(jwtService.getToken(usuario))
					.build();
				
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
}
		
		// TODO Auto-generated constructor stub
	
	
	
	