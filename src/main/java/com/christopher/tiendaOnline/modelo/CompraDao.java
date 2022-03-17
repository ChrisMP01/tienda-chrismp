package com.christopher.tiendaOnline.modelo;

import java.util.List;

import com.christopher.tiendaOnline.entidades.Compra;
import com.christopher.tiendaOnline.entidades.Producto;

public interface CompraDao extends DaoGenerico<Compra>{
	List<Compra> findAll();
}
