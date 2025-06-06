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
    public String CategoriaHome(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "/Categorias/Index";
    }

}

