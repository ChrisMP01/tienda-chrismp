package com.christopher.tiendaOnline.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.christopher.tiendaOnline.entidades.Pregunta;
import com.christopher.tiendaOnline.modelo.PreguntaRepository;

public class PreguntaServiceImpl implements PreguntaService {
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Override
	public int guardarPregunta(Pregunta pregunta) {
		try {
			preguntaRepository.save(pregunta);
			return 1;
		}catch(Exception e) {
			return 0;
		}
		
	}

	@Override
	public Pregunta obtenerPregunta(Long id) {
		Pregunta findById=preguntaRepository.findById(id).orElse(null);
		if(findById!=null) {
			return findById;
		}else
			return null;
	}
	
}
