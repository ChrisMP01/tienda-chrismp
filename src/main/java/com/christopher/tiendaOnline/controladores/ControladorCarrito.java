package com.christopher.tiendaOnline.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.ProductoCompra;
import com.christopher.tiendaOnline.servicios.ProductoService;

@Controller
public class ControladorCarrito {
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "carrito/anadir/{id}", method = RequestMethod.GET)
	public String anadirProducto(HttpSession httpSession,  @PathVariable Long id) {		
		
		
		List<ProductoCompra> carrito=(List<ProductoCompra>) httpSession.getAttribute("carrito");
		//Llamar al servicio pasandole el id del producto y la lista de objeto en la session
		//Si esta vacio le pasamos null
		//TODO Recuperamos el carrito de la session sino existe lo creamos
		//Introducimos el producto con ProdcutoCompra en el carrito
		//Comprobamos si el producto existe ene  el carrito
		//Si ya existe el producto modificamos la cantidad del producto
		//Si no existe lo insertamos con unidad 1
		Producto producto= productoService.buscarId(id);
		ProductoCompra productoCompra= new ProductoCompra(producto.getId_prod(), producto.getNom_prod(), producto.getPrecio(), 1);
		if(carrito==null) {
			carrito=new ArrayList<ProductoCompra>();
			carrito.add(productoCompra);
		}else {
			Boolean anadido = false;
			for (ProductoCompra p : carrito) {
				long elId= p.getId_prod();
				if (elId == id) {
					p.setUnidades(p.getUnidades() + productoCompra.getUnidades());
					p.setPrecio(p.getPrecio()+productoCompra.getPrecio());
					anadido=true;
				}
			}
			if (!anadido) carrito.add(productoCompra);
		}
		
		httpSession.setAttribute("carrito", carrito);
		return "redirect:/carrito/mostrar";
	}
	
	@RequestMapping(value = "carrito/mostrar", method = RequestMethod.GET)
	public String verCarrito(HttpSession httpSession,Model modelo) {

		List<ProductoCompra> lista_carrito=(List<ProductoCompra>) httpSession.getAttribute("carrito");

		
		modelo.addAttribute("lista_carrito",lista_carrito);
		
		return "carrito";
	}
	
	
}
