package com.food.foodieapp.repositories.Producto;

import com.food.foodieapp.models.Producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategorias_Id(Long categoriaId);
    List<Producto> findBySupermercado_Id(Long supermercadoId);
    List<Producto> findByCategorias_IdAndSupermercado_Id(Long categoriaId, Long supermercadoId);

}
