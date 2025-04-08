package com.example.eccomerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    // Este endpoint solo será accesible para usuarios PREMIUM, gracias a la configuración en SecurityConfig
    @GetMapping
    public String getDashboard() {
        return "Bienvenido al Dashboard Premium!";
    }
}

