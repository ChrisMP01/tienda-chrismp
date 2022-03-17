package com.christopher.tiendaOnline.servicios;

import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.christopher.tiendaOnline.entidades.Imagen;
import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.modelo.ImagenRepository;
import com.christopher.tiendaOnline.modelo.ProductoDao;

@Transactional
@Service
public class ImagenServiceImpl implements ImagenService {

	@Autowired
	private ImagenRepository imagenRepository;
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	public int guardarImagen(Imagen img) {
		// TODO Auto-generated method stub
		try {
			imagenRepository.save(img);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public Imagen obtenerImagen(Long id) {
		// TODO Auto-generated method stub
		Imagen findById=imagenRepository.findById(id).orElse(null);
		if(findById!=null) {
			Imagen getImageDetails=findById;
			return findById;
		}else {
			return null;
		}
	}

	@Override
	public Boolean actualizarImagen(Long id, MultipartFile file) {
		// TODO Auto-generated method stub
		Producto p=productoDao.buscar(id);
		
		if(p==null)
			return false;
		
		try {
			byte[] image=file.getBytes();
			if(!p.getImagen().isEmpty()) {
				
				Set<Imagen> limg=p.getImagen();
				for(Imagen a:limg) {
					a.setImagen(image);
					imagenRepository.save(a);
					return true;
				}
				return null;
			}else {
				Imagen img=new Imagen("foto",image);
				p.addImagen(img);
				productoDao.crear(p);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(imagenRepository, productoDao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagenServiceImpl other = (ImagenServiceImpl) obj;
		return Objects.equals(imagenRepository, other.imagenRepository)
				&& Objects.equals(productoDao, other.productoDao);
	}

	@Override
	public String toString() {
		return "ImagenServiceImpl [imagenRepository=" + imagenRepository + ", productoDao=" + productoDao + "]";
	}
	
	
}
