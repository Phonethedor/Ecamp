package com.repaso.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers") //tabla que referenciara
public class Cliente {
	
	@Id
	private Integer customerId;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "cliente") //tipo de relacion y el atributo que se utilizara para refernciar
	@JsonIgnore
	private List<Orden> ordenes;
	
	public Cliente() {
		
	}

	public Cliente(Integer customerId, String firstName, String lastName, List<Orden> ordenes) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ordenes = ordenes;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
}
