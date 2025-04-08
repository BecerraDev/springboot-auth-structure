package com.example.eccomerce.service;

import org.springframework.stereotype.Service;
import com.example.eccomerce.entity.Product;
import com.example.eccomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Crear o actualizar un producto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Eliminar un producto por ID
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    // Buscar productos por nombre
    public List<Product> getProductsByName(String nombre) {
        return productRepository.findByNombre(nombre);
    }
}