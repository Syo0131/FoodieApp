package com.food.foodieapp.repositories;
import com.food.foodieapp.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository <Usuarios, Long>
{
}
