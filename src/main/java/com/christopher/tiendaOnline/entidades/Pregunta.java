package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//Crear tabla pregunta en base de datos.
@Table(name="pregunta")
public class Pregunta implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_pregunta;
	
	private String pregunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	
	public Pregunta() {
		super();
	}
	
	public Pregunta(Long id_pregunta, String pregunta, Usuario usuario) {
		super();
		this.id_pregunta = id_pregunta;
		this.pregunta = pregunta;
		this.usuario = usuario;
	}
	
	public Long getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Long id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
