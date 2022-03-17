package com.christopher.tiendaOnline.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.modelo.ProductoDao;

@Controller
public class ControladorIndex {
	
	@Autowired
	ProductoDao productoDao;
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index_get(Model model) {
		
		List<Producto> lProductos = productoDao.findAll();
		model.addAttribute("lista_prod",lProductos);
		
		return "index";
	}
	 
}
