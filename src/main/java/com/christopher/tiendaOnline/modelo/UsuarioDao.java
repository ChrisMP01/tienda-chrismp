package com.christopher.tiendaOnline.modelo;

import java.util.List;

import com.christopher.tiendaOnline.entidades.Rol;
import com.christopher.tiendaOnline.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario>{
	Usuario buscarUsuario(Long idUsuario);
	Usuario login(String nombreUsuario, String passUsuario);
	Usuario buscarNombre(String nombreUsuario);
}
