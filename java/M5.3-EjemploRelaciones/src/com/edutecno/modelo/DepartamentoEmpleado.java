package com.edutecno.modelo;

public class DepartamentoEmpleado {
	
	//atributos
	private Departamento departamento;
	private Empleado empleado;
	
	//constructor con parametros
	public DepartamentoEmpleado(Departamento departamento, Empleado empleado) {
		this.departamento = departamento;
		this.empleado = empleado;
	}
	//getters y setters
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
