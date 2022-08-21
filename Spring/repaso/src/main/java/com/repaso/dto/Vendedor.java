package com.repaso.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "staffs")
public class Vendedor {
	
	@Id
	private Integer staffId;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "vendedor")
	@JsonIgnore
	private List<Orden> ordenes;

	public Vendedor() {
		
	}
	
	public Vendedor(Integer staffId, String firstName, String lastName, List<Orden> ordenes) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ordenes = ordenes;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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
