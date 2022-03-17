package com.christopher.tiendaOnline.controladores;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.servicios.ProductoService;

@Controller
public class ControladorProducto {

	@Autowired
	ProductoService productoService;

	@RequestMapping(value = "producto/crear", method = RequestMethod.GET)
	public String crearProducto_get() {

		return "crearProducto";
	}

	@RequestMapping(value = "producto/crear", method = RequestMethod.POST)
	public String crearProducto(Model modelo, @RequestParam String titulo, @RequestParam String descripcion,
			@RequestParam float precio, @RequestParam int descuento) {

		Producto p = new Producto(null, titulo, descripcion, precio, descuento);
		
		//productoDao.guardar(p);
		List<Producto> productos = productoService.findAll();
		modelo.addAttribute("lista_prod", productos);
		return "redirect:/index";
	}

	@RequestMapping(value = "producto/{id}", method = RequestMethod.GET)
	public String prodcutoId(Model modelo, @PathVariable Long id) {

		Producto producto= productoService.buscarId(id);
		modelo.addAttribute("producto", producto);
		
		return "perfilProducto";
	}

	@RequestMapping(value = "producto/borrar/{id}", method = RequestMethod.GET)
	public String borrarProducto(Model modelo, @PathVariable Long id) {
		//productoDao.delete(id);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "producto/buscar", method = RequestMethod.GET)
	public String productoNom(Model modelo, @RequestParam String buscar) {
		
		List<Producto> productos=productoService.buscarNombre(buscar);
		modelo.addAttribute("lista_prod",productos);
		return "listaProducto";
	}
}
