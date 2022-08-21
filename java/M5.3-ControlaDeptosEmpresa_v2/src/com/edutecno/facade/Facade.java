package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.BusquedaEmpleadoDao;
import com.edutecno.dao.BusquedaEmpleadoDaoImp;
import com.edutecno.dao.LoginDao;
import com.edutecno.dao.LoginDaoImp;
import com.edutecno.model.Empleado;

public class Facade {
	
	public List<Empleado> busquedaEmpleado(String nombre, int numEmpleado, int numDepartamento){
		BusquedaEmpleadoDao busquedaEmpleadoDao = new BusquedaEmpleadoDaoImp();

		return busquedaEmpleadoDao.busquedaEmpleado(nombre, numEmpleado, numDepartamento);
	}
	public boolean usuarioRegistrado(String correo, String password) {
		LoginDao loginDao = new LoginDaoImp();
		return loginDao.usuarioRegistrado(correo, password);
	}
}
