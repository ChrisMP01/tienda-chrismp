package com.christopher.tiendaOnline.servicios;

import org.springframework.web.multipart.MultipartFile;

import com.christopher.tiendaOnline.entidades.Imagen;

public interface ImagenService {
	public int guardarImagen(Imagen img);
	public Imagen obtenerImagen(Long id);
	public Boolean actualizarImagen(Long id, MultipartFile file);
}
