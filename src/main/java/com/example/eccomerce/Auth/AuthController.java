package com.example.eccomerce.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
		
	private final AuthService authService;
	
	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
	{
		return ResponseEntity.ok(authService.login(request));
	}
	
	
	@PostMapping(value = "register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
	{				
		
		return ResponseEntity.ok(authService.register(request));
	}
	
	@GetMapping(value = "register")
	public ResponseEntity<String> getRegisterInfo() {
	    // Puedes devolver una descripción o mensaje acerca de cómo registrarse
	    String info = "Para registrarse, envía una solicitud POST con los datos necesarios como nombre, correo y contraseña.";
	    return ResponseEntity.ok(info);
	}
}
