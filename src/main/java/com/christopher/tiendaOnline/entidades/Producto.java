package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="productos")
public class Producto implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -9022916655833441709L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prod;
	@Column(name="titulo")
	private String nom_prod;
	
	private String descripcion;
	
	private Float precio;
	
	private Integer descuento;
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "producto", orphanRemoval = true)
	private Set<Imagen> imagen = new HashSet<>();
	
	@OneToMany(
	        mappedBy = "producto",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<CompraProducto> lugarCompra = new ArrayList<>();
	
	
	public Producto(String nom_prod, String descripcion, Float precio, Integer descuento) {
		super();
		this.nom_prod = nom_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public Producto(Long id_prod, String nom_prod, String descripcion, Float precio, Integer descuento) {
		super();
		this.id_prod = id_prod;
		this.nom_prod = nom_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
	}

	public Producto() {
		super();
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	public void addImagen(Imagen img) {
		this.imagen.add(img);
		img.setProducto(this);
	}
	
	public void removeImagen(Imagen img) {
		img.setProducto(null);
		this.imagen.remove(img);
	}
	
	public void removeImagenes() {
		Iterator<Imagen> iterator=this.imagen.iterator();
		while(iterator.hasNext()) {
			Imagen img=iterator.next();
			img.setProducto(null);
			iterator.remove();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, descuento, id_prod, lugarCompra, nom_prod, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(id_prod, other.id_prod) && Objects.equals(lugarCompra, other.lugarCompra)
				&& Objects.equals(nom_prod, other.nom_prod) && Objects.equals(precio, other.precio);
	}

	public Set<Imagen> getImagen() {
		return imagen;
	}

	public void setImagen(Set<Imagen> imagen) {
		this.imagen = imagen;
	}
	
}
