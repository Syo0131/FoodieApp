package com.food.foodieapp.controller.TiendasController;

import com.food.foodieapp.models.Tiendas.Supermercado;
import com.food.foodieapp.repositories.Tiendas.SupermercadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupermercadoController {

    private final SupermercadoRepository supermercadoRepository;
    public SupermercadoController(SupermercadoRepository supermercadoRepository) {
        this.supermercadoRepository = supermercadoRepository;
    }


    @GetMapping("/Supermercado")
    public String SupermercadoHome(Model model){
        model.addAttribute("supermercado", supermercadoRepository.findAll());
        return "/Tiendas/Index";
    }

    @GetMapping("/Supermercado/Crear")
    public String supermercadoformulario( Model model){
        model.addAttribute("supermercado", new Supermercado());
        return "/Tiendas/Create";
    }
    @PostMapping("/Supermercado/Crear")
    public String GuardarSupermercado(@ModelAttribute Supermercado supermercado){
        supermercadoRepository.save(supermercado);
        return "redirect:/Supermercado";
    }
}
