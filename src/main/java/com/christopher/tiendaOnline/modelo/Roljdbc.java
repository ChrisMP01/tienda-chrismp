package com.christopher.tiendaOnline.modelo;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.christopher.tiendaOnline.entidades.Rol;
import com.christopher.tiendaOnline.entidades.Usuario;

@Repository
public class Roljdbc extends DaoGenericoImpl<Rol>implements RolDao {
	/*@Override
	public int darRol(Usuario usuario) {
		// TODO Auto-generated method stub
		Query query=this.em.createQuery("from Rol ");
		return 0;//cambiar
		
	}*/
}
