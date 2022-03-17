package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Rol implements Serializable{
	
	@Id
	//@Column(name="idRol")
	private Long id_rol;
	//@Column(name="nombreRol")
	private String nombre_rol;
	
	@ManyToMany(mappedBy = "userRoles")
	private Set<Usuario> usuarios = new HashSet<>();
	
	public Rol() {
	}

	public Rol(Long idRol, String nombreRol) {
		super();
		this.id_rol = idRol;
		this.nombre_rol = nombreRol;
	}

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", nombre_rol=" + nombre_rol + ", usuarios=" + usuarios + "]";
	}
	
	
	
	
}
