package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.DepartamentoDao;
import com.edutecno.dao.DepartamentoDaoImp;
import com.edutecno.dao.DepartamentoEmpleadoDao;
import com.edutecno.dao.DepartamentoEmpleadoDaoImpl;
import com.edutecno.dao.EmpleadoDao;
import com.edutecno.dao.EmpleadoDaoImp;
import com.edutecno.model.Departamento;
import com.edutecno.model.DepartamentoEmpleado;
import com.edutecno.model.Empleado;

//Facade es un patrón de diseño que ejecuta una entrada única a la capa de persistencia de datos
public class Facade {
	
	//metodo encargado de acceder al data access object DepartamentoDaoImp
	public List<Departamento> obtieneDepartamentos(){
		
		//se realiza una instancia de DepartamentoDao generando un nuevo DepartamentoDaoImp
		DepartamentoDao departamentoDao = new DepartamentoDaoImp();
		return departamentoDao.obtieneDepartamentos();
	}
	//metodo encargado de acceder al data access object EmpleadoDaoImp
	public List<Empleado> obtieneEmpleados(){
		
		//se realiza una instancia de EmpleadoDao generando un nuevo EmpleadoDaoImp
		EmpleadoDao empleadoDao = new EmpleadoDaoImp();
		return empleadoDao.obtieneEmpleados();
	}
	//metodo encargado de acceder al data access object DepartamentoEmpleadoImp
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto){
		//se realiza una instancia de DepartamentoEmpleadoDao generando un nuevo DepartamentoEmpleadoDaoImpl
		DepartamentoEmpleadoDao departamentoEmpleadoDao = new DepartamentoEmpleadoDaoImpl();
		return departamentoEmpleadoDao.obtieneDepartamento(nomDepto);
	}
}
