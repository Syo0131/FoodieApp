package com.food.foodieapp.models.Producto;

import com.food.foodieapp.models.Tiendas.Supermercado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
