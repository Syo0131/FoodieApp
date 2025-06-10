package com.food.foodieapp.controller.Auth;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String redirect(Authentication auth) {
        String role = auth.getAuthorities().iterator().next().getAuthority();
        return role.equals("ROLE_ADMIN") ? "redirect:/Admin/Home" : "redirect:/Home";
    }
}
