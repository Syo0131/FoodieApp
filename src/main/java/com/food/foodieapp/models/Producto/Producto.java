package com.food.foodieapp.models.Producto;

import com.food.foodieapp.models.Categorias.Categoria;
import com.food.foodieapp.models.Tiendas.Supermercado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double precio;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "supermercado_id")
    private Supermercado supermercado;

    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

}
