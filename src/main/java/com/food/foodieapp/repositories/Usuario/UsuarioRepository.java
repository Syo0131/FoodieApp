package com.food.foodieapp.repositories.Usuario;
import com.food.foodieapp.models.Usuario.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository <Usuarios, Long>
{
}
