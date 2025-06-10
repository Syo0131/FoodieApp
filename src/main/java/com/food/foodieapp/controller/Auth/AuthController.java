package com.food.foodieapp.controller.Auth;


import com.food.foodieapp.models.Usuario.Usuarios;
import com.food.foodieapp.repositories.Usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new Usuarios());
        return "Usuario/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuarios user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol(user.getRol());
        usuarioRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "Auth/login";
    }
}
