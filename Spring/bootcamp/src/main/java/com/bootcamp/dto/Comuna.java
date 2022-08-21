package com.bootcamp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comuna")
public class Comuna {
	
	@Id
	private Integer codigo_comuna;
	
	@OneToMany(mappedBy = "comuna")
	@JsonIgnore
	private List<Estudiante> estudiantes;
	
	@OneToMany(mappedBy = "comuna")
	@JsonIgnore
	private List<Curso> cursos;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="codigo_region")
	private Region region;
	
	public Comuna() {
		
	}

	public Comuna(Integer codigo_comuna, List<Estudiante> estudiantes, List<Curso> cursos, Region region) {
		super();
		this.codigo_comuna = codigo_comuna;
		this.estudiantes = estudiantes;
		this.cursos = cursos;
		this.region = region;
	}

	public Integer getCodigo_comuna() {
		return codigo_comuna;
	}

	public void setCodigo_comuna(Integer codigo_comuna) {
		this.codigo_comuna = codigo_comuna;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public List<Curso> getCursos(){
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}
