package com.food.foodieapp.models.Tiendas;

import com.food.foodieapp.models.Producto.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Supermercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;
    private  Long telefono;


    @OneToMany(mappedBy = "supermercado", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();
}
