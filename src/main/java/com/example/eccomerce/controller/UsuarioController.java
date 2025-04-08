package com.example.eccomerce.controller;

import com.example.eccomerce.entity.Usuario;
import com.example.eccomerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Obtener un usuario por su email
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Usuario>> obtenerPorUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.obtenerPorUsername(username);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<Usuario> crearOActualizarUsuario(@RequestBody Usuario usuario) {
        // Si el ID del usuario es nulo o no existe, se crea un nuevo usuario
        // Si el ID existe, se actualiza el usuario existente
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.status(201).body(usuarioGuardado);  // Retorna un HTTP 201 (Creado)
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();  // Retorna un HTTP 204 (Sin contenido)
    }
}
