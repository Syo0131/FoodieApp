package com.food.foodieapp.models.Usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido;
    @Column(nullable=false)
    private String correo;
    @Column(nullable=false)
    private String password;
    @Column(unique = true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String rol;

}
