package com.christopher.tiendaOnline.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christopher.tiendaOnline.entidades.Rol;
import com.christopher.tiendaOnline.entidades.Usuario;
import com.christopher.tiendaOnline.modelo.RolDao;
import com.christopher.tiendaOnline.modelo.UsuarioDao;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService,UserDetailsService {

	@Autowired
	RolDao rolDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario registro(Usuario usuario) {
		usuario.setPass_usuario(bCryptPasswordEncoder.encode(usuario.getPass_usuario()));
		Rol rol = rolDao.buscar(2L);
		usuario.anadirRol(rol);
		
		return usuarioDao.crear(usuario);
	}

	@Override
	public Usuario buscarUsuario(Long idUsuario) {
		return usuarioDao.buscarUsuario(idUsuario);
	}

	@Override
	public Usuario login(String nombreUsuario, String passUsuario) {
		return usuarioDao.login(nombreUsuario, passUsuario);
	}

	@Override
	public Usuario buscarNombre(String nombreUsuario) {
		return usuarioDao.buscarNombre(nombreUsuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario=usuarioDao.buscarNombre(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Rol rol : usuario.getUserRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre_rol()));
        }

        return new org.springframework.security.core.userdetails.User(usuario.getNombre_usuario(), usuario.getPass_usuario(),
                grantedAuthorities);
	}

}
