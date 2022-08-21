package com.jvega.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users implements Serializable {

		//se facilita su conversion a,l momento de la compilacion, 
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private Role role;
	
	
}
