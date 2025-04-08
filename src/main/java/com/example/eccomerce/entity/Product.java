package com.example.eccomerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Producto")
public class Product {
		
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String nombre;
		
	    @Column(name = "descripcion")  // Cambio el nombre de la columna a 'descripcion' si 'description' es problemático.
		private String descripcion;
		
	    private BigDecimal descuento;
	    
		private int precio;
		
		

	
		public void setDescuento(BigDecimal descuento) {
			this.descuento = descuento;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
		
		public BigDecimal getDescuento() {
			return descuento;
		}
	
		
		
}
