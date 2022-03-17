package com.christopher.tiendaOnline.servicios;

import java.util.List;
import java.util.Map;

import com.christopher.tiendaOnline.entidades.Producto;

public interface ProductoService {
	Producto crear(Producto t);
	void borrar(Object id);
	int index();
	Producto buscarId(Long idProd) ;
	List<Producto> buscarNombre(String nomProd);
	List<Producto> findAll();
}
