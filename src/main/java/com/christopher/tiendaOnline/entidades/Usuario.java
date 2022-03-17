package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8968635648829403237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	private String nombre_usuario;

	private String apellido_usuario;

	private String pass_usuario;
	
	private String email;
	
	private String fecha_nac;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Compra> compras = new HashSet<Compra>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pregunta> preguntas=new HashSet<Pregunta>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "rol_user", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> userRoles = new HashSet<Rol>();

	public boolean anadirCompra(Compra compra) {
		compra.setUsuario(this);
		return getCompras().add(compra);
	}

	public void devolverCompra(Compra compra) {
		getCompras().remove(compra);
	}

	public boolean anadirRol(Rol rol) {
		rol.getUsuarios().add(this);
		return getUserRoles().add(rol);
	}

	public void eliminarRol(Rol rol) {
		this.userRoles.remove(rol);
		rol.getUsuarios().remove(this);
	}

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String passUsuario, String email,
			String fechaNac) {
		super();
		this.id_usuario = idUsuario;
		this.nombre_usuario = nombreUsuario;
		this.apellido_usuario = apellidoUsuario;
		this.pass_usuario = passUsuario;
		this.email = email;
		this.fecha_nac = fechaNac;
	}

	public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, String passUsuario, String email,
			String fechaNac, HashSet<Rol> userRoles) {
		super();
		this.id_usuario = idUsuario;
		this.nombre_usuario = nombreUsuario;
		this.apellido_usuario = apellidoUsuario;
		this.pass_usuario = passUsuario;
		this.email = email;
		this.fecha_nac = fechaNac;
		this.userRoles = userRoles;
	}

	public Set<Rol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(HashSet<Rol> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public String getPass_usuario() {
		return pass_usuario;
	}

	public void setPass_usuario(String pass_usuario) {
		this.pass_usuario = pass_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fechaNac) {
		this.fecha_nac = fechaNac;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public void setUserRoles(Set<Rol> userRoles) {
		this.userRoles = userRoles;
	}

}
