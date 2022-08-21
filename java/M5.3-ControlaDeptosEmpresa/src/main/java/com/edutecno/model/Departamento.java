package com.edutecno.model;

public class Departamento {
	
	//atributos
	private int numDepto;
	private String nombreDepto;
	private String ubicacionDepto;
	
	//constructor vacio
	public Departamento() {
	}
	//constructor con parametros
	public Departamento(int numDepto, String nombreDepto, String ubicacionDepto) {
		super();
		this.numDepto = numDepto;
		this.nombreDepto = nombreDepto;
		this.ubicacionDepto = ubicacionDepto;
	}
	//getters y setters
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
	//metodo toString()
	@Override
	public String toString() {
		return "Departamento [numDepto=" + numDepto + ", nombreDepto=" + nombreDepto + ", ubicacionDepto="
				+ ubicacionDepto + "]";
	}
}
