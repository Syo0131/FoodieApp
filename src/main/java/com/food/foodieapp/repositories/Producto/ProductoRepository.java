package com.food.foodieapp.repositories.Producto;

import com.food.foodieapp.models.Producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
