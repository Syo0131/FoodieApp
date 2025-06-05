package com.food.foodieapp.controller.Usuario;

import org.springframework.ui.Model;
import com.food.foodieapp.repositories.Usuario.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @GetMapping("/usuario")
    public String UsuarioHome(Model model) {
        model.addAttribute("usuario", usuarioRepository.findAll());
        return "Usuario/Index";
    }
}
