package com.christopher.tiendaOnline.modelo;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.christopher.tiendaOnline.entidades.Producto;

@Repository
public class Productojdbc extends DaoGenericoImpl<Producto> implements ProductoDao {

	@Override
	public int index() {
		return 0;
	}

	@Override
	public Producto buscarId(Long id_prod) throws EmptyResultDataAccessException {
		try {
			Query query=this.em.createQuery("from Producto where id_prod= :idprod");
			query.setParameter("idprod", id_prod);
			return null;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Producto> buscarNombre(String nom_prod) {
		// TODO Auto-generated method stub
		Query query=this.em.createQuery("from Producto where titulo like :nomprod");
		query.setParameter("nomprod", nom_prod);
		List<Producto> lprod=query.getResultList();
		return null;
	}
	
//org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'idProd' cannot be found on object of type 'com.christopher.tiendaOnline.entidades.Producto'
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		//Limitar a 8 productos.
	Query query=this.em.createQuery("FROM Producto ORDER BY id_prod");//ASC LIMIT 8
		List<Producto> prodAll=query.getResultList();
		return prodAll;
	}
}
