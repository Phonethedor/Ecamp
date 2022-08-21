package com.repaso.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stores")
public class Tienda {
	
	@Id
	private Integer storeId;
	
	private String storeName;
	
	@OneToMany(mappedBy = "tienda")
	@JsonIgnore
	private List<Orden> ordenes;
	
	public Tienda() {
		
	}

	public Tienda(Integer storeId, String storeName, List<Orden> ordenes) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.ordenes = ordenes;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	

}
