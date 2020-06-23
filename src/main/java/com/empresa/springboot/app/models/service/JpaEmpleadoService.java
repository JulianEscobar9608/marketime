
/*
package com.empresa.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.models.dao.IEmpleadoCrud;
import com.empresa.springboot.app.models.entity.Empleado;
import com.empresa.springboot.app.models.entity.Roles;

@Service("jpaEmpleadoService ")
public class JpaEmpleadoService implements UserDetailsService {

	@Autowired
	private IEmpleadoCrud empleadocrud;
 
	private Logger logger = LoggerFactory.getLogger(JpaEmpleadoService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Empleado empleado = empleadocrud.findByNombre(username);

		if (empleado == null) {

			logger.error("Error login: No existe el usuario '" + username + "'");
			throw new UsernameNotFoundException("Username " + username + " no existe en el sistema");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Roles role : empleado.getRoles()) {
			logger.info("Role: ".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		if (authorities.isEmpty()) {
			logger.error("Error login: el usuario '" + username + "' No tiene roles asignados");
			throw new UsernameNotFoundException("EL Username " + username + " no tiene roles asignados");

		}

		return new User(username, empleado.getContrasena(), empleado.getEnabled(), true, true, true, authorities);
	}

}

*/