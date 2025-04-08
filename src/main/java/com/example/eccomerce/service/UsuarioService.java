package com.example.eccomerce.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eccomerce.entity.Usuario;
import com.example.eccomerce.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por su ID
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null); // Si no lo encuentra, retorna null
    }

    // Obtener un usuario por su email (puedes usar otro campo de búsqueda)
    public Optional<Usuario> obtenerPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Guardar un nuevo usuario o actualizar uno existente
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por su ID
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

