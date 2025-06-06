package com.food.foodieapp.controller.Producto;

import com.food.foodieapp.models.Categorias.Categoria;
import com.food.foodieapp.models.Producto.Producto;
import com.food.foodieapp.models.Tiendas.Supermercado;
import com.food.foodieapp.repositories.Categorias.CategoriaRepository;
import com.food.foodieapp.repositories.Producto.ProductoRepository;
import com.food.foodieapp.repositories.Tiendas.SupermercadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductoController {

    private final SupermercadoRepository supermercadoRepository;
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;


    public ProductoController(SupermercadoRepository supermercadoRepository, ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.supermercadoRepository = supermercadoRepository;
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;

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
        model.addAttribute("categorias",categoriaRepository.findAll());
        model.addAttribute("productos", new Producto());
        model.addAttribute("supermercados", supermercadoRepository.findAll());

       return "/Producto/Create";
    }

    @PostMapping("/Producto/Crear")
    public String GuardarProductos(@ModelAttribute Producto producto) {
        Long supermercadoId = producto.getSupermercado().getId();
        Long categoriaId = null;
        if (!producto.getCategorias().isEmpty()) {
            categoriaId = producto.getCategorias().get(0).getId();
        }


        assert categoriaId != null;
        Categoria categorias = (Categoria) categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Supermercado no encontrado"));
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

    @GetMapping("/Producto/Editar")
    public String mostrarEditar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("categorias",categoriaRepository.findAll());
        model.addAttribute("supermercado", supermercadoRepository.findAll());
        productoRepository.findById(id).ifPresent(producto -> model.addAttribute("producto", producto));
        return "/Producto/Editar";
    }

    @PostMapping("/Producto/Editar")
    public String editarProducto(@ModelAttribute Producto producto) {
        productoRepository.save(producto);
        return "redirect:/Producto";
    }


    @PostMapping("/Producto/Eliminar/{id}")
    public String EliminarProductos(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return "redirect:/Producto";
    }

}
