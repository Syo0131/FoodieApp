package com.food.foodieapp.repositories.Categorias;

import com.food.foodieapp.models.Categorias.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
