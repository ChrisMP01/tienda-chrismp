package com.christopher.tiendaOnline.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.christopher.tiendaOnline.entidades.Compra;
import com.christopher.tiendaOnline.entidades.Producto;

@Repository
public class Comprajdbc extends DaoGenericoImpl<Compra> implements CompraDao{

	@Override
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		Query query=this.em.createQuery("from Compra order by id_compra");
		List<Compra> l_compra=query.getResultList();
		return l_compra;
	}
}
