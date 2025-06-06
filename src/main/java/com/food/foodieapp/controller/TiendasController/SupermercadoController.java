package com.food.foodieapp.controller.TiendasController;

import com.food.foodieapp.models.Tiendas.Supermercado;
import com.food.foodieapp.repositories.Producto.ProductoRepository;
import com.food.foodieapp.repositories.Tiendas.SupermercadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupermercadoController {

    private final SupermercadoRepository supermercadoRepository;


    public SupermercadoController(SupermercadoRepository supermercadoRepository) {
        this.supermercadoRepository = supermercadoRepository;
    }


    @GetMapping("/Supermercado")
    public String SupermercadoHome(Model model) {
        model.addAttribute("supermercados", supermercadoRepository.findAll());
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

   @GetMapping("/Supermercado/Editar")
   public String editarSupermercado(@RequestParam("id") Long id, Model model){
        supermercadoRepository.findById(id).ifPresent(supermercado -> model.addAttribute("supermercado", supermercado));
        return "/Tiendas/Editar";
   }
   @PostMapping("/Supermercado/Editar")
    public String PosteditarSupermercado(@ModelAttribute Supermercado supermercado){
        supermercadoRepository.save(supermercado);
        return "redirect:/Supermercado";
   }
    @GetMapping("/Supermercado/Eliminar")
    public String eliminarSupermercado(@RequestParam("id") Long id, Model model){
        supermercadoRepository.findById(id).ifPresent(supermercado -> model.addAttribute("supermercado", supermercado));
        return "/Tiendas/Eliminar";

    }

    @PostMapping("/Supermercado/Eliminar/{id}")
    public String eliminarSupermercado(@PathVariable Long id){
        supermercadoRepository.deleteById(id);
        return "redirect:/Supermercado";
    }

}
