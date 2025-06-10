package com.food.foodieapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UsuarioSecurity {

    @Bean
    public SecurityFilterChain AuthUser (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.requestMatchers("/Auth/login", "/register", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/Admin/**").hasRole("ADMIN")
                        .requestMatchers( "/Producto", "/Categoria","/Supermercado").hasRole("USER")
                        .requestMatchers("/register", "/login", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/redirect", true)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll()).exceptionHandling(exception -> exception.accessDeniedPage("/access-denied"));

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
