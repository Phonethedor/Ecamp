package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Departamento;
import com.edutecno.procesaConexion.AdministradorConexion;

public class DepartamentoDaoImp extends AdministradorConexion implements DepartamentoDao {
	
	public DepartamentoDaoImp() {
		  conn = generaPoolConexion();
	}
	@Override
	public List<Departamento> obtieneDepartamento() {

		String sql = "SELECT * FROM DEPARTAMENTO";
		List<Departamento> deptos = new ArrayList<Departamento>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Departamento depto = new Departamento (rs.getInt("NUMDEPTO"),rs.getString("NOMDEPTO"),rs.getString("UBICACIONDPTO"));
				deptos.add(depto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptos;
	}

}
