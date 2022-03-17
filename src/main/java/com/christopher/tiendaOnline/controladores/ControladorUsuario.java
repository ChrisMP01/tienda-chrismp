package com.christopher.tiendaOnline.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.christopher.tiendaOnline.entidades.Usuario;
import com.christopher.tiendaOnline.modelo.RolDao;
import com.christopher.tiendaOnline.servicios.RolService;
import com.christopher.tiendaOnline.servicios.UsuarioService;

@Controller
public class ControladorUsuario {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolDao rolDao;
	
	@RequestMapping(value="usuario/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="usuario/login", method=RequestMethod.POST)
	public String login_post(HttpSession httpSession,@RequestParam String nombreUsuario, @RequestParam String passUsuario) {
		
		Usuario usuario=usuarioService.login(nombreUsuario, passUsuario);
		//modelo.addAttribute(usuario);
		httpSession.setAttribute("usuario", usuario);
		return "redirect:/index";
	}
	
	@RequestMapping(value="usuario/signup", method=RequestMethod.GET)
	public String registroUsuario_get() {
		return "registroUsuario";
	}
	
	@RequestMapping(value="usuario/signup", method=RequestMethod.POST)
	public String registroUsuario_post(Model modelo,@RequestParam String nombreUsuario,@RequestParam String apellidoUsuario,
	@RequestParam String passUsuario,@RequestParam String email,@RequestParam String fechaNac) {
		
		Usuario usuario=new Usuario(null, nombreUsuario, apellidoUsuario, passUsuario, email, fechaNac);
		usuarioService.registro(usuario);
		//rolDao.darRol(usuario);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "usuario/{id}", method = RequestMethod.GET)
	public String usuarioId(Model modelo, @PathVariable Long id) {

		Usuario usuario= usuarioService.buscarUsuario(id);
		modelo.addAttribute("usuario", usuario);
		return "perfilUsuario";
	}
	
	@RequestMapping(value = "usuario/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		httpSession.invalidate();
		return "redirect:/index";
	}
		
}
