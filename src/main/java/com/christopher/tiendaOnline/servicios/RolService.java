package com.christopher.tiendaOnline.servicios;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.Rol;

public interface RolService {
	Rol crear(Rol t);
	void borrar(Object id);
}
