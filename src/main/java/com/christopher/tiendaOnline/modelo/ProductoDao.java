package com.christopher.tiendaOnline.modelo;

import java.util.List;

import com.christopher.tiendaOnline.entidades.Producto;

public interface ProductoDao extends DaoGenerico<Producto>{
	int index();
	Producto buscarId(Long idProd) ;
	List<Producto> buscarNombre(String nomProd);
	List<Producto> findAll();
}
