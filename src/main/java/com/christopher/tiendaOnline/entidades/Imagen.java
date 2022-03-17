package com.christopher.tiendaOnline.entidades;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imagen")
public class Imagen {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_imagen;
	
	private String nombre_imagen;
	@Lob
	private byte[] imagen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	/*
	 * <div class="d-flex flex-column align-items-center text-center"  th:if="${imagen ==null}">
						<img th:src="@{/images/default.png}" alt="Admin" class="rounded-circle" width="207">
					</div>
					<div class="d-flex flex-column align-items-center text-center"  th:if="${imagen !=null}">
						<img th:src="@{/imagenes/{id_producto}(id_producto=${producto.id_prod})}" alt="Admin" class="rounded-circle" width="207">
					</div>
	 */
	
	public Imagen() {
		super();
	}
	
	public Imagen(String nombre_imagen, byte[] imagen) {
		super();
		this.nombre_imagen = nombre_imagen;
		this.imagen = imagen;
	}
	
	public Long getId_imagen() {
		return id_imagen;
	}

	public void setId_imagen(Long id_imagen) {
		this.id_imagen = id_imagen;
	}

	public String getNombre_imagen() {
		return nombre_imagen;
	}

	public void setNombre_imagen(String nombre_imagen) {
		this.nombre_imagen = nombre_imagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagen);
		result = prime * result + Objects.hash(id_imagen, nombre_imagen);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagen other = (Imagen) obj;
		return Objects.equals(id_imagen, other.id_imagen) && Arrays.equals(imagen, other.imagen)
				&& Objects.equals(nombre_imagen, other.nombre_imagen);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
