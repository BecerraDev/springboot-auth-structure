package com.example.eccomerce.repository;

import org.springframework.stereotype.Repository;
import com.example.eccomerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
    List<Product> findByNombre(String nombre);  // Aquí se declara el método de búsqueda.

}
