package com.christopher.tiendaOnline.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christopher.tiendaOnline.entidades.Imagen;

@Repository
public interface ImagenRepository extends CrudRepository<Imagen, Long> {

}
