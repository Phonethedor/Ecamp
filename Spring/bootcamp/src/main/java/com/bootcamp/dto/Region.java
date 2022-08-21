package com.bootcamp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="region")
public class Region {
	
	@Id
	private Integer codigo_region;
	
	private String nombre;
	
	@OneToMany(mappedBy = "region")
	@JsonIgnore
	private List<Comuna> comunas;
	
	public Region() {
		
	}

	public Region(Integer codigo_region, String nombre, List<Comuna> comunas) {
		super();
		this.codigo_region = codigo_region;
		this.nombre = nombre;
		this.comunas = comunas;
	}

	public Integer getCodigo_region() {
		return codigo_region;
	}

	public void setCodigo_region(Integer codigo_region) {
		this.codigo_region = codigo_region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Comuna> getComunas() {
		return comunas;
	}

	public void setComunas(List<Comuna> comunas) {
		this.comunas = comunas;
	}
	
	

}
