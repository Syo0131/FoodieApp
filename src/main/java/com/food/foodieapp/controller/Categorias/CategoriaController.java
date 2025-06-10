package com.food.foodieapp.controller.Categorias;

import com.food.foodieapp.repositories.Categorias.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {

    private  final CategoriaRepository categoriaRepository;
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/Categoria")
    public String CategoriaUserHome(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "RolUser/Categorias/Index";
    }
    @GetMapping("/Admin/Categoria")
    public String CategoriaAdminHome(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "Admin/Categorias/Index";
    }

}

