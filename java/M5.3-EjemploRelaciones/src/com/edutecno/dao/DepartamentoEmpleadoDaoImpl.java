package com.edutecno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.modelo.Departamento;
import com.edutecno.modelo.DepartamentoEmpleado;
import com.edutecno.modelo.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

public class DepartamentoEmpleadoDaoImpl extends AdministradorConexion implements DepartamentoEmpleadoDao {
	
	public DepartamentoEmpleadoDaoImpl() {//constructor vacío
		conn = generaPoolConexion();//se genera la conexion para toda la clase
	}
	
	@Override
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto) {
		//lista para almacenar los datos obtenidos de la base de datos
		List<DepartamentoEmpleado> deptosEmpleados = new ArrayList<DepartamentoEmpleado>();
		String query = "SELECT * FROM EMPLEADO EMP INNER JOIN DEPARTAMENTO DEP ON DEP.NUMDEPTO = EMP.NUMDEPTO\r\n" + "WHERE ";
		
		if (nomDepto.isEmpty()) {
			query = "SELECT * FROM EMPLEADO EMP INNER JOIN DEPARTAMENTO DEP ON DEP.NUMDEPTO = EMP.NUMDEPTO";
		}else {
			query += "DEP.NOMDEPTO LIKE UPPER('%"+nomDepto+"%')";
		}
		
//		String query = "SELECT * FROM EMPLEADO EMP INNER JOIN DEPARTAMENTO DEP ON DEP.NUMDEPTO = EMP.NUMDEPTO WHERE "+ "DEP.NOMDEPTO LIKE UPPER('%"+nomDepto+"%')";
		
		try {
			//se prepara la query
			pstm = conn.prepareStatement(query);
			//se ejecuta la query
			rs = pstm.executeQuery();
			//se recorre el resultado
			while(rs.next()) {
				Departamento depto = new Departamento (rs.getInt("NUMDEPTO"), rs.getString("NOMDEPTO"), rs.getString("UBICACIONDPTO"));
				Empleado empleado = new Empleado(rs.getInt("NUMEMPLEADO"), rs.getString("NOMBRE"), rs.getInt("NUMDEPTO"));
				DepartamentoEmpleado deptoEmpl = new DepartamentoEmpleado(depto, empleado);
				deptosEmpleados.add(deptoEmpl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptosEmpleados;
	}
}
