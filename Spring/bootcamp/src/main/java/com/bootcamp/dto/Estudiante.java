package com.bootcamp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
	
	@Id
	private Integer id_estudiante;
	
	private String rut;
	private String nombre;
	private String apellido_pat;
	private String apellido_mat;
	
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="codigo_comuna")
	private Comuna comuna;
	
	public Estudiante() {
		
	}

	public Estudiante(Integer id_estudiante, String rut, String nombre, String apellido_pat, String apellido_mat,
			Curso curso, Comuna comuna) {
		super();
		this.id_estudiante = id_estudiante;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
		this.curso = curso;
		this.comuna = comuna;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_pat() {
		return apellido_pat;
	}

	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}

	public String getApellido_mat() {
		return apellido_mat;
	}

	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Comuna getComuna() {
		return comuna;
	}
	
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
	
	
}
