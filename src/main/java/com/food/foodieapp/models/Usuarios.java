package com.food.foodieapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuarios {


    @Id
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Password;

//            Get And Set


//    ID
   public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
//    Nombre
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
//    Apellido
    public String getApellido() {
       return Apellido;
    }
    public void setApellido(String Apellido) {
       this.Apellido = Apellido;
    }
//    Correo
    public String getCorreo() {
       return Correo;
    }
    public void setCorreo(String Correo) {
       this.Correo = Correo;
    }
//    Password
    public String getPassword() {
       return Password;
    }
    public void setPassword(String Password) {
       this.Password = Password;
    }
}
