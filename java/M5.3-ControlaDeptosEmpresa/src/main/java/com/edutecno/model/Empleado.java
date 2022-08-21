package com.edutecno.model;

//objeto que representa a la entidad (tabla) en la base de datos, objeto de modelo de negocio
public class Empleado {
	//atributos
	private int numEmpleado;
	private String nombreEmpleado;
	private int numDepto;
	
	//constructor vacio
	public Empleado() {
	}
	//constructor con parametros
	public Empleado(int numEmpleado, String nombreEmpleado, int numDepto) {
		super();
		this.numEmpleado = numEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.numDepto = numDepto;
	}
	//getters y setters
	public int getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public int getNumDepto() {
		return numDepto;
	}
	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}
	//metodo toString()
	@Override
	public String toString() {
		return "Empleado [numEmpleado=" + numEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", numDepto=" + numDepto
				+ "]";
	}
}
