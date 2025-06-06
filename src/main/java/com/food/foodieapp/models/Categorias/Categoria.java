package com.food.foodieapp.models.Categorias;


import com.food.foodieapp.models.Producto.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;



    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos = new ArrayList<>();
}
