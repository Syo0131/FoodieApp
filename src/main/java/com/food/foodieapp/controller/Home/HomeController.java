package com.food.foodieapp.controller.Home;

import com.food.foodieapp.models.Producto.Producto;
import com.food.foodieapp.repositories.Categorias.CategoriaRepository;
import com.food.foodieapp.repositories.Producto.ProductoRepository;
import com.food.foodieapp.repositories.Tiendas.SupermercadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private  final CategoriaRepository categoriaRepository;
    private  final ProductoRepository productoRepository;
    private  final SupermercadoRepository supermercadoRepository;

    public HomeController(CategoriaRepository categoriaRepository, ProductoRepository productoRepository, SupermercadoRepository supermercadoRepository){
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
        this.supermercadoRepository = supermercadoRepository;
    }

    @GetMapping("/Home")
    public String HomeIndex(@RequestParam(required = false) Long categoriaId,
                            @RequestParam(required = false) Long supermercadoId,
                            Model model) {

        List<Producto> productos;

        if (categoriaId != null && supermercadoId != null) {
            productos = productoRepository.findByCategorias_IdAndSupermercado_Id(categoriaId, supermercadoId);
        } else if (categoriaId != null) {
            productos = productoRepository.findByCategorias_Id(categoriaId);
        } else if (supermercadoId != null) {
            productos = productoRepository.findBySupermercado_Id(supermercadoId);
        } else {
            productos = productoRepository.findAll();
        }

        model.addAttribute("producto", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("supermercado", supermercadoRepository.findAll());

        // Mantener filtros seleccionados
        model.addAttribute("categoriaId", categoriaId);
        model.addAttribute("supermercadoId", supermercadoId);

        return "/Home/Index";
    }


}
