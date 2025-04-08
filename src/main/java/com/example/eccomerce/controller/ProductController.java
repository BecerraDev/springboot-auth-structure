package com.example.eccomerce.controller;

import com.example.eccomerce.entity.Product;
import com.example.eccomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Usamos @RestController para devolver respuestas directas, sin necesidad de vista.
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:3000")  // Permite solicitudes desde React
public class ProductController {

    @Autowired
    private ProductService productService;

    // Listar todos los productos
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();  // Devuelve la lista de productos directamente en formato JSON
    }

    // Insertar un nuevo producto
    @PostMapping("/save")
    public String saveNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Producto guardado con éxito";  // Respuesta básica
    }

    // Actualizar un producto
    @PostMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);  // Guardamos el producto, ya sea insertando o actualizando
        return "Producto actualizado con éxito";  // Respuesta básica
    }
}

