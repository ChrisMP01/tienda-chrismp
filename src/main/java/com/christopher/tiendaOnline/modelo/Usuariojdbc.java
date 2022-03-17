package com.christopher.tiendaOnline.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.christopher.tiendaOnline.entidades.Rol;
import com.christopher.tiendaOnline.entidades.Usuario;

@Repository
public class Usuariojdbc extends DaoGenericoImpl<Usuario> implements UsuarioDao {
	

	@Override
	public Usuario buscarUsuario(Long id_usuario) {
		try {
			Query query=this.em.createQuery("from Usuario where id_usuario= :id_user");
			query.setParameter("id_user", id_usuario);
			return (Usuario) query.getSingleResult();
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Usuario login(String nombre_usuario, String pass_usuario) {
		try {
			Query query=this.em.createQuery("from Usuario where nombre_usuario=:nom_us and pass_usuario=:pass_us");
			query.setParameter("nom_us", nombre_usuario);
			query.setParameter("pass_us", pass_usuario);
			return (Usuario) query.getSingleResult();
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Usuario buscarNombre(String nom_usuario) {
		Query query=this.em.createQuery("from Usuario where nombre_usuario= :nom_us");
		query.setParameter("nom_us",nom_usuario);
		return (Usuario) query.getSingleResult();
	}

}
