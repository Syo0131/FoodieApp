package com.food.foodieapp.controller;

import org.springframework.ui.Model;
import com.food.foodieapp.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/Usuario")
    public String index(Model model) {
        model.addAttribute("Usuario", usuarioRepository.findAll());
        return "Usuario/Index";
    }
}
