package com.jvega.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jvega.mapper.UsersMapper;
import com.jvega.model.Users;

@Service
public class AuthServiceImp implements UserDetailsService {

	@Autowired
	private UsersMapper userMapper; //inyeccion de dependencias del repositorio para invocarlo y consultar por el usuario
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Users user = userMapper.findByEmail(email);  //buscando el usaurio por email mediante UsersMapper
		if (user == null) {
			throw new UsernameNotFoundException(email); //se ejecuta un nuevo erro de username no encontrado
		}
		//se instancia una lista de tipo GrantedAuthority
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		
		//El rol viene desde la Base de datos, como un String ADMIN , CLIENT
		//Al crear un SimlpeGrantedAuthority se asigna una autoridad de tipo ej. ROLE_ADMIN, ROLE_CLIENT
		System.out.println(authorities);
		
		//se retorna un User de la libreria import org.springframework.security.core.userdetails.User;
		//User(email, password, authorities)
		//asigmando datos del usuario encontrado a la base d e datos a User de userdetails
		return new User(user.getEmail(), user.getPassword(), authorities);
	}

}
