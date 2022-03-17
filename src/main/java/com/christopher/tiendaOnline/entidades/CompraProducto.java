package com.christopher.tiendaOnline.entidades;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="compra_producto")
public class CompraProducto {

	@EmbeddedId
	private Compra_productoId id;
	
	private Float unidades;
	

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_compra")
    @JoinColumn(name="id_compra")
	private Compra compra;
	

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_prod")
    @JoinColumn(name="id_prod")	
    private Producto producto;

    
    public CompraProducto() {
		super();
	}
    
    public CompraProducto(Compra_productoId id, Float unidades, Compra compra, Producto producto) {
		super();
		this.id = id;
		this.unidades = unidades;
		this.compra = compra;
		this.producto = producto;
	}

	public Compra_productoId getId() {
		return id;
	}

	public void setId(Compra_productoId id) {
		this.id = id;
	}

	public Float getUnidades() {
		return unidades;
	}

	public void setUnidades(Float unidades) {
		this.unidades = unidades;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compra, id, producto, unidades);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraProducto other = (CompraProducto) obj;
		return Objects.equals(compra, other.compra) && Objects.equals(id, other.id)
				&& Objects.equals(producto, other.producto) && Objects.equals(unidades, other.unidades);
	}
}
