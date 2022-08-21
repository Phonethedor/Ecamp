package com.bootcamp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="plan_formativo")
public class Plan_formativo {

	@Id
	private String codigo_plan_formativo;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "plan_formativo")
	@JsonIgnore
	private List<Curso> cursos;
	
	public Plan_formativo() {
		
	}

	public Plan_formativo(String codigo_plan_formativo, String descripcion, List<Curso> cursos) {
		super();
		this.codigo_plan_formativo = codigo_plan_formativo;
		this.descripcion = descripcion;
		this.cursos = cursos;
	}

	public String getCodigo_plan_formativo() {
		return codigo_plan_formativo;
	}

	public void setCodigo_plan_formativo(String codigo_plan_formativo) {
		this.codigo_plan_formativo = codigo_plan_formativo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
