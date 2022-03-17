package com.christopher.tiendaOnline.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christopher.tiendaOnline.entidades.Compra;
import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.ProductoCompra;
import com.christopher.tiendaOnline.entidades.Usuario;
import com.christopher.tiendaOnline.modelo.CompraDao;
import com.christopher.tiendaOnline.modelo.ProductoDao;
import com.christopher.tiendaOnline.modelo.UsuarioDao;

@Service
@Transactional
public class CompraServiceImpl implements CompraService {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	CompraDao compraDao;

	@Override
	public Compra realizarCompra(Usuario usuario, ProductoCompra productoCompra) {
		Compra compra=new Compra(null,productoCompra.getPrecio(),productoCompra.getUnidades());
		//Compra compra=new Compra(null,usuario.getId_usuario(),productoCompra.getId_prod(),productoCompra.getPrecio(),productoCompra.getUnidades());
		return compraDao.crear(compra);
	}
	
	@Override
	public List<Compra> findAll() {
		return compraDao.findAll();
	}

	@Override
	public Producto buscarProdCompra(Compra compra) {
		// TODO Auto-generated method stub
		
		return productoDao.buscarId(compra.getId_compra());
		//return null;
	}

	@Override
	public Compra buscarCompra(Long id) {
		// TODO Auto-generated method stub
		return compraDao.buscar(id);
	}

	@Override
	public void devolverCompra(Long id) {
		// TODO Auto-generated method stub
		compraDao.borrar(id);
	}
	
}
