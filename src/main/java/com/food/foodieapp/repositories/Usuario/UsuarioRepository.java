package com.food.foodieapp.repositories.Usuario;
import com.food.foodieapp.models.Usuario.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuarios, Long>
{

    Optional<Object> findByUsername(String username);
}
