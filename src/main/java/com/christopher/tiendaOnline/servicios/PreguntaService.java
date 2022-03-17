package com.christopher.tiendaOnline.servicios;

import com.christopher.tiendaOnline.entidades.Pregunta;

public interface PreguntaService {
	public int guardarPregunta(Pregunta pregunta);
	
	public Pregunta obtenerPregunta(Long id);
}
