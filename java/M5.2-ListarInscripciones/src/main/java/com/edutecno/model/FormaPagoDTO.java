package com.edutecno.model;
//un objeto DTO es un objeto de transferencia de datos, DATA TRANSFER OBJECT
public class FormaPagoDTO {
	
	//atributos
	private String idFormaPago;
	private String descripcion;
	private String recargo;
	
	//constructor vacio
	public FormaPagoDTO() {
	}
	//constructor  con parametros
	public FormaPagoDTO(String idFormaPago, String descripcion, String recargo) {
		super();
		this.idFormaPago = idFormaPago;
		this.descripcion = descripcion;
		this.recargo = recargo;
	}
	//getters y setters
	public String getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRecargo() {
		return recargo;
	}
	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}
	//metodo toString()
	@Override
	public String toString() {
		return "FormaPagoDTO [idFormaPago=" + idFormaPago + ", descripcion=" + descripcion + ", recargo=" + recargo
				+ "]";
	}
}
