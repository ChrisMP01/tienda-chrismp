package com.christopher.tiendaOnline.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="respuesta")
public class Respuesta implements Serializable{
	
	@Id
	private Long id_respuesta;
	
	private String respuesta;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	
	public Respuesta() {
		super();
	}
	
	public Respuesta(Long id_respuesta, String respuesta/*, Pregunta pregunta*/, Usuario usuario) {
		super();
		this.id_respuesta = id_respuesta;
		this.respuesta = respuesta;
		//this.pregunta = pregunta;
		this.usuario = usuario;
	}
	
	public Long getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(Long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/*public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}*/

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
