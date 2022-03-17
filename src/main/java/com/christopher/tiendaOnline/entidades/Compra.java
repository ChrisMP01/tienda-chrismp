package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;
	
	private Float precio;
	
	private Integer unidades;
	
	@OneToMany(
	        mappedBy = "compra",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<CompraProducto> listaProd = new ArrayList<>();
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Compra() {
		super();
	}
	
	public Compra(Long id_compra, Float precio, Integer unidades) {
		super();
		this.id_compra = id_compra;
		this.precio = precio;
		this.unidades = unidades;
	}


	public Long getId_compra() {
		return id_compra;
	}


	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Integer getUnidades() {
		return unidades;
	}


	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_compra, listaProd, precio, unidades, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(id_compra, other.id_compra) && Objects.equals(listaProd, other.listaProd)
				&& Objects.equals(precio, other.precio) && Objects.equals(unidades, other.unidades)
				&& Objects.equals(usuario, other.usuario);
	}
	
}
