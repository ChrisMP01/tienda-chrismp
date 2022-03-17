package com.christopher.tiendaOnline.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christopher.tiendaOnline.entidades.Compra;
import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.entidades.ProductoCompra;
import com.christopher.tiendaOnline.entidades.Usuario;
import com.christopher.tiendaOnline.servicios.CompraService;
import com.christopher.tiendaOnline.servicios.UsuarioService;

@Controller
public class ControladorCompra {
	
	@Autowired
	CompraService compraService;
	@Autowired
	UsuarioService usuarioService;
	
	
	@RequestMapping(value="compra/producto/{id}", method = RequestMethod.GET)
	public String compraProducto(HttpSession httpSession, @PathVariable Long id) {
		
		List<ProductoCompra> carrito=(List<ProductoCompra>) httpSession.getAttribute("carrito");
		
		Long idUsuario=(Long) httpSession.getAttribute("idUsuario");
		Usuario user=usuarioService.buscarUsuario(idUsuario);
		ProductoCompra productoCompra=null;
		
		for (ProductoCompra p : carrito) {
			long elId= p.getId_prod();
			if (elId == id) {
				productoCompra=p;
			}
		}

		compraService.realizarCompra(user, productoCompra);
		return "redirect:/compra/mostrar";
	}
	
	@RequestMapping(value="compra/mostrar", method=RequestMethod.GET)
	public String verCompra(HttpSession httpSession, Model modelo) {
		
		List<Compra> lista_compra=compraService.findAll();
		modelo.addAttribute("lista_compra", lista_compra);
		return "compra";
	}
	
	@RequestMapping(value="perfilCompra/{id}", method=RequestMethod.GET)
	public String verProdCompra(HttpSession httpSession, Model modelo, @PathVariable Long id) {
		Compra compra=compraService.buscarCompra(id);
		Producto producto=compraService.buscarProdCompra(compra);
		
		modelo.addAttribute("compra", compra);
		modelo.addAttribute("producto", producto);
		
		return "perfilCompra";
	}
	
	@RequestMapping(value="devolverCompra/{id}", method=RequestMethod.GET)
	public String devolverCompra(Model modelo,@PathVariable Long id) {
		
		compraService.devolverCompra(id);
		
		return "redirect:/compra/mostrar";
	}
	
}
