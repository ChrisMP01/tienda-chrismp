package com.christopher.tiendaOnline.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.Rol;
import com.christopher.tiendaOnline.modelo.RolDao;

public class RolServiceImpl implements RolService{
	
	@Autowired
	RolDao rolDao;
	
	@Override
	public Rol crear(Rol t) {
		// TODO Auto-generated method stub
		return rolDao.crear(t);
	}

	@Override
	public void borrar(Object id) {
		// TODO Auto-generated method stub
		
	}

}
