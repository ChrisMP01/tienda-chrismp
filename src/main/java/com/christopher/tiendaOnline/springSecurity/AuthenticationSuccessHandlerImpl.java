package com.christopher.tiendaOnline.springSecurity;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.christopher.tiendaOnline.entidades.Usuario;
import com.christopher.tiendaOnline.servicios.UsuarioService;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UsuarioService usuarioService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpSession session = request.getSession();
		//System.out.println(userDetails.getUsername());
		Usuario usuario = usuarioService.buscarNombre(userDetails.getUsername());
		session.setAttribute("username", usuario.getNombre_usuario());
		session.setAttribute("nombre", usuario.getApellido_usuario());
		session.setAttribute("idUsuario", usuario.getId_usuario());
		
		boolean isCliente = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("cliente")) {
				isCliente = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("admin")) {
				isAdmin = true;
				break;
			}
		}
		String targetUrl = "/index"; // solo borra el = /index
		if (isCliente) {
			targetUrl = "/index";
		} else if (isAdmin) {
			targetUrl = "/index";
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
}