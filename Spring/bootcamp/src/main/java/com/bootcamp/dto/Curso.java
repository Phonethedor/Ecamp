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
@Table(name = "curso")
public class Curso {
	
	@Id
	private String codigo_curso;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "codigo_plan_formativo")
	private Plan_formativo plan_formativo;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "codigo_comuna")
	private Comuna comuna;
	
	@OneToMany(mappedBy = "curso")
	@JsonIgnore
	private List<Estudiante> estudiantes;
	
	public Curso() {
		
	}

	public Curso(String codigo_curso, Plan_formativo plan_formativo, List<Estudiante> estudiantes, Comuna comuna) {
		super();
		this.codigo_curso = codigo_curso;
		this.plan_formativo = plan_formativo;
		this.estudiantes = estudiantes;
		this.comuna = comuna;
	}

	public String getCodigo_curso() {
		return codigo_curso;
	}

	public void setCodigo_curso(String codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public Plan_formativo getPlan_formativo() {
		return plan_formativo;
	}

	public void setPlan_formativo(Plan_formativo plan_formativo) {
		this.plan_formativo = plan_formativo;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public Comuna getComuna() {
		return comuna;
	}
	
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
}
