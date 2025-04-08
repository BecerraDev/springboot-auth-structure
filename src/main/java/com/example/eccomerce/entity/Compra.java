package com.example.eccomerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Compra")
public class Compra {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Product producto;

    private BigDecimal precioOriginal; // Precio original del producto
    private BigDecimal descuentoProducto; // Descuento aplicado al producto (ej. 20%)
    private BigDecimal descuentoUsuario; // Descuento del tipo de usuario (ej. 50% para PREMIUM)
    private BigDecimal descuentoTotal; // Descuento total aplicado (suma de los dos descuentos)
    private BigDecimal precioFinal; // Precio final después de aplicar los descuentos
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Product getProducto() {
		return producto;
	}
	public void setProducto(Product producto) {
		this.producto = producto;
	}
	public BigDecimal getPrecioOriginal() {
		return precioOriginal;
	}
	public void setPrecioOriginal(BigDecimal precioOriginal) {
		this.precioOriginal = precioOriginal;
	}
	public BigDecimal getDescuentoProducto() {
		return descuentoProducto;
	}
	public void setDescuentoProducto(BigDecimal descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	public BigDecimal getDescuentoUsuario() {
		return descuentoUsuario;
	}
	public void setDescuentoUsuario(BigDecimal descuentoUsuario) {
		this.descuentoUsuario = descuentoUsuario;
	}
	public BigDecimal getDescuentoTotal() {
		return descuentoTotal;
	}
	public void setDescuentoTotal(BigDecimal descuentoTotal) {
		this.descuentoTotal = descuentoTotal;
	}
	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

    
    
	;
	
}
