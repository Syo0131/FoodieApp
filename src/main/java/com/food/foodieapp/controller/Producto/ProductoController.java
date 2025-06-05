package com.food.foodieapp.controller.Producto;

import com.food.foodieapp.models.Producto.Producto;
import com.food.foodieapp.models.Tiendas.Supermercado;
import com.food.foodieapp.repositories.Producto.ProductoRepository;
import com.food.foodieapp.repositories.Tiendas.SupermercadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    private final SupermercadoRepository supermercadoRepository;
    private final ProductoRepository productoRepository;


    public ProductoController(SupermercadoRepository supermercadoRepository, ProductoRepository productoRepository) {
        this.supermercadoRepository = supermercadoRepository;
        this.productoRepository = productoRepository;
    }


    @GetMapping("/Producto")
    public String ProductoHome(Model model)
    {
        model.addAttribute("productos",productoRepository.findAll());
        return "Producto/Index";
    }

    @GetMapping("/Producto/Crear")
    public String formulario(Model model )
    {
        model.addAttribute("productos", new Producto());
        model.addAttribute("supermercados", supermercadoRepository.findAll());

       return "/Producto/Create";
    }

    @PostMapping("/Producto/Crear")
    public String GuardarProductos(@ModelAttribute Producto producto) {
        Long supermercadoId = producto.getSupermercado().getId();

        Supermercado supermercado = supermercadoRepository.findById(supermercadoId)
                .orElseThrow(() -> new IllegalArgumentException("Supermercado no encontrado"));

        producto.setSupermercado(supermercado);
        productoRepository.save(producto);

        return "redirect:/Producto";
    }

    @GetMapping("/Producto/Eliminar")
    public String mostrarConfirmacionEliminar(@RequestParam("id") Long id, Model model) {
        productoRepository.findById(id).ifPresent(producto -> model.addAttribute("producto", producto));
        return "/Producto/Eliminar"; // Asegúrate de que esta vista existe
    }



    @PostMapping("/Producto/Eliminar/{id}")
    public String EliminarProductos(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return "redirect:/Producto";
    }

}
