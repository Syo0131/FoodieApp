package com.food.foodieapp.security;

import com.food.foodieapp.models.Usuario.Usuarios;
import com.food.foodieapp.repositories.Usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    private final UsuarioRepository userRepository;

    public CustomUserService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 1. Buscar el usuario en base de datos
        Usuarios user = (Usuarios) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe"));

        // 2. Retornar un objeto que Spring Security entienda (UserDetails)
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // debe estar encriptada
                .roles(user.getRol().replace("ROLE_", ""))
                .build();
    }
}

