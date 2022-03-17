package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;

public class ProductoCompra implements Serializable {

	private Long id_prod;
	private String nom_prod;
	private float precio;
	private int unidades;
	
	
	public ProductoCompra() {
		super();
	}
	public ProductoCompra(Long id_prod, String nom_prod, float precio, int unidades) {
		super();
		this.id_prod = id_prod;
		this.nom_prod = nom_prod;
		this.precio = precio;
		this.unidades = unidades;
	}
	
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Long getId_prod() {
		return id_prod;
	}
	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}
	
	
}
