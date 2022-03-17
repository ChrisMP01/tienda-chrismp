package com.christopher.tiendaOnline.servicios;

import com.christopher.tiendaOnline.entidades.Usuario;

public interface UsuarioService {
	Usuario registro(Usuario usuario);
	Usuario buscarUsuario(Long idUsuario);
	Usuario login(String nombreUsuario, String passUsuario);
	Usuario buscarNombre(String nombreUsuario);
}
