package com.edutecno.model;

public class Departamento {
	//ATRIBUTOS
	private int numDepto;
	private String nombreDepto;
	private String ubicacionDepto;
	//CONSTRUCTOR ESTANDAR
	public Departamento() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS
	public Departamento(int numDepto, String nombreDepto, String ubicacionDepto) {
		super();
		this.numDepto = numDepto;
		this.nombreDepto = nombreDepto;
		this.ubicacionDepto = ubicacionDepto;
	}
	//GETTER Y SETTER
	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}

	public String getNombreDepto() {
		return nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public String getUbicacionDepto() {
		return ubicacionDepto;
	}

	public void setUbicacionDepto(String ubicacionDepto) {
		this.ubicacionDepto = ubicacionDepto;
	}
}
