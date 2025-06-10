package com.food.foodieapp.models.Usuario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void testSettersAndGetters() {
        Usuarios user = new Usuarios();
        user.setNombre("Juan");
        user.setApellido("Pérez");
        user.setUsername("juan123");
        user.setPassword("secreto");
        user.setRol("ROLE_USER");

        assertEquals("Juan", user.getNombre());
        assertEquals("Pérez", user.getApellido());
        assertEquals("juan123", user.getUsername());
        assertEquals("secreto", user.getPassword());
        assertEquals("ROLE_USER", user.getRol());
    }
}