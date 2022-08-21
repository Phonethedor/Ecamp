package com.repaso.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orden {

	@Id
	private Integer orderId;
	
	@Column(columnDefinition = "tinyint")
	private Integer orderStatus;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	
	//relaciones
	@ManyToOne
	@JoinColumn(name= "customer_id") //nombre de la columna de la fk
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name= "store_id")
	private Tienda tienda;
	
	@ManyToOne
	@JoinColumn(name= "staff_id")
	private Vendedor vendedor;
	
	public Orden() {
		
	}

	public Orden(Integer orderId, Integer orderStatus, LocalDate orderDate, LocalDate requiredDate, Cliente cliente,
			Tienda tienda, Vendedor vendedor) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.cliente = cliente;
		this.tienda = tienda;
		this.vendedor = vendedor;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
