package com.edutecno.dao;

import java.sql.SQLException;

import com.edutecno.procesaConexion.AdministradorConexion;

public class LoginDaoImp  extends AdministradorConexion implements LoginDao{
	
	public LoginDaoImp() {
		  conn = generaPoolConexion();
	}
	
	@Override
	public boolean usuarioRegistrado(String correo, String password) {

		boolean usuarioExiste = false;
		 String sql = "SELECT * FROM USUARIOS_ADMIN WHERE CORREO = '" +correo + "'" + "AND PASS = '" + password + "'";
		
		 try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				usuarioExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioExiste;
	}

}
