package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.Empleado;
import com.edutecno.procesaConexion.AdministradorConexion;

//EmpleadoDaoImp hereda desde AdministradorConexion e implementa los metodos de la interfaz EmpleadoDao
public class EmpleadoDaoImp extends AdministradorConexion implements EmpleadoDao {
	
	//cuando se realice la instancia de EmpleadoDaoImp se ejecuta una conexion o se obtiene una conexion existente
	public EmpleadoDaoImp() {
		conn = generaPoolConexion();
	}
	
	@Override
	public List<Empleado> obtieneEmpleados() {
		//lista para almacenar los empleados consultados a la base de datos
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		try {
			//preparacion de la query a ejecutar
			pstm = conn.prepareStatement("SELECT * FROM empleado");
			rs = pstm.executeQuery();//ejecucion de la query SELECT
			while (rs.next()) {//se verifica que la fila tenga datos
				Empleado empleado = new Empleado();//objeto temporal para crear el objeto del registro en la base de datos
				//seteando los valores obtenidos de cada columna por su nombre mediante el ResultSet
				empleado.setNumEmpleado(rs.getInt("NUMEMPLEADO"));
				empleado.setNombreEmpleado(rs.getString("NOMBRE"));
				empleado.setNumDepto(rs.getInt("NUMDEPTO"));
				
				listaEmpleados.add(empleado);//se agrega el objeto temporal empleado a la lista listaEmpleados
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEmpleados;
	}
}
