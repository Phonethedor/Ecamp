package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.Empleado;

public interface BusquedaEmpleadoDao {
	
	public List<Empleado> busquedaEmpleado (String nombre,int numEmpleado, int numDepartamento);
}
