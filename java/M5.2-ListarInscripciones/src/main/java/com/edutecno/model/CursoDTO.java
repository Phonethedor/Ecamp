package com.edutecno.model;

//un objeto DTO es un objeto de transferencia de datos, DATA TRANSFER OBJECT
public class CursoDTO {
	
	//atributos
	private int idCurso;
	private String descripcion;
	private int precio;
	
	//constructor vacio
	public CursoDTO() {
	}
	//constructor con parametros
	public CursoDTO(int idCurso, String descripcion, int precio) {
		super();
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	//getters y setters
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	//metodo toString()
	@Override
	public String toString() {
		return "CursoDTO [idCurso=" + idCurso + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
}
