package com.christopher.tiendaOnline.servicios;

import java.util.List;

import com.christopher.tiendaOnline.entidades.Compra;
import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.ProductoCompra;
import com.christopher.tiendaOnline.entidades.Usuario;

public interface CompraService {
	Compra realizarCompra(Usuario usuario, ProductoCompra productoCompra);
	List<Compra> findAll();
	Producto buscarProdCompra(Compra compra);
	Compra buscarCompra(Long id);
	void devolverCompra(Long id);
}
