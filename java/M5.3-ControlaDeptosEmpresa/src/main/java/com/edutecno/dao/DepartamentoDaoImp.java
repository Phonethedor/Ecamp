package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Departamento;
import com.edutecno.procesaConexion.AdministradorConexion;
//DepartamentoDaoImp herada (extends) de Administrador de conexion e implementa la interfaz DepartamentoDao
public class DepartamentoDaoImp extends AdministradorConexion implements DepartamentoDao {
	
	//constructor vacio
	public DepartamentoDaoImp() {
		conn = generaPoolConexion();
	}
	
	//sobreescritura del metodo existente en la interfaz
	//metodo encargado de consultar por todos los departamentos existentes en la base de datos
	@Override
	public List<Departamento> obtieneDepartamentos() {
		
		//lista para almacenar los departamentos obtenidos de la consulta
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		
		try {
			//preparar la query para la ejecucion con el PreparedStatement y Connection
			pstm = conn.prepareStatement("SELECT * FROM departamento");
			//se ejecuta la query con pstm.executeQuery()
			rs = pstm.executeQuery();
			while (rs.next()) {//se verifica que en la fila donde se encuentra el rs tenga datos
				Departamento departamento = new Departamento();//instancia temporal de tipo Departamento
				//seteando el objeto temporal con los datos obtenidos del ResultSet
				departamento.setNumDepto(rs.getInt("NUMDEPTO"));
				departamento.setNombreDepto(rs.getString("NOMDEPTO"));
				departamento.setUbicacionDepto(rs.getString("UBICACIONDPTO"));
				
				listaDepartamentos.add(departamento);//se agrega el objeto temporal a la listaDepartamentos
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDepartamentos;
	}
}
