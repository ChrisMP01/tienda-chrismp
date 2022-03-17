package com.christopher.tiendaOnline.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.modelo.ProductoDao;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDao productoDao;

	@Override
	public Producto crear(Producto t) {
		// TODO Auto-generated method stub
		return productoDao.crear(t);
	}

	@Override
	public void borrar(Object id) {
		// TODO Auto-generated method stub
		productoDao.borrar(id);
	}

	@Override
	public int index() {
		// TODO Auto-generated method stub
		return productoDao.index();
	}

	@Override
	public Producto buscarId(Long id_prod) {
		// TODO Auto-generated method stub
		return productoDao.buscar(id_prod);
	}

	@Override
	public List<Producto> buscarNombre(String nom_prod) {
		// TODO Auto-generated method stub
		return productoDao.buscarNombre(nom_prod);
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}
}
