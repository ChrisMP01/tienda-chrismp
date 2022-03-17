package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Compra_productoId implements Serializable{
	
	private Long id_compra;
	
	private Long id_prod;
	
	public Compra_productoId() {
		super();
	}
	public Compra_productoId(Long id_compra, Long id_prod) {
		super();
		this.id_compra = id_compra;
		this.id_prod = id_prod;
	}
	public Long getId_compra() {
		return id_compra;
	}
	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}
	public Long getId_prod() {
		return id_prod;
	}
	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_compra, id_prod);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra_productoId other = (Compra_productoId) obj;
		return Objects.equals(id_compra, other.id_compra) && Objects.equals(id_prod, other.id_prod);
	}
}
