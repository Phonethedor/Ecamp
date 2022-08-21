package com.edutecno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

public class BusquedaEmpleadoDaoImp extends AdministradorConexion implements BusquedaEmpleadoDao{

	public BusquedaEmpleadoDaoImp() {
		 conn = generaPoolConexion();
	}
	
	@Override
	public List<Empleado> busquedaEmpleado(String nombre, int numEmpleado, int numDepartamento) {
		
		String query ="SELECT * FROM EMPLEADO WHERE ";
		
		List<Empleado> empleados = new ArrayList<Empleado>();
	
	if ((nombre.isEmpty()) && (numEmpleado == 0 && numDepartamento == 0)) {
		query = "SELECT * FROM EMPLEADO ";
	}else {
		//si ninguno de los campos esta vacio y son mayores a 0, contiene un valor a buscar
		if ((!nombre.isEmpty() && (numEmpleado > 0) && (numDepartamento > 0))) {
			query.concat("NOMBRE = '"+nombre+"'"+ "AND" + "NUMEMPLEADO = "+numEmpleado+ " AND " + " NUMDEPTO = " +numDepartamento);
		}
		else if (!nombre.isEmpty()) {//si solo el nombre no esta vacio
//				query += "NOMBRE = '"+nombre+"'";
				query += "UPPER (NOMBRE) LIKE UPPER('%"+nombre+"%')";
//				SELECT * FROM EMPLEADO WHERE UPPER(NOMBRE) LIKE UPPER ('%bob%');
			}
			
		else if (numEmpleado > 0) {//si solo el numero de empleado no esta vacio
				query += "NUMEMPLEADO = "+numEmpleado;
			}
			
		else if (numDepartamento > 0) {//si el numero de departamento no esta vacio
				query += "NUMDEPTO = "+numDepartamento;
			}
			
		}
	System.out.println(query);

	try {
		pstm = conn.prepareStatement(query);
		rs = pstm.executeQuery();
		while (rs.next()) {
			Empleado empleado = new Empleado (rs.getInt("NUMEMPLEADO"), rs.getString("NOMBRE"), rs.getInt("NUMDEPTO"));
			empleados.add(empleado);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
		return empleados;
	}

}
