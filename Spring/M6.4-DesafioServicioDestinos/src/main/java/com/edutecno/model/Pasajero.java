package com.edutecno.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "SQ_PASAJERO", initialValue = 1, allocationSize = 1, sequenceName = "SQ_PASAJERO")
public class Pasajero {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASAJERO")
	private Long id;
	@Column(nullable = false, unique = true)
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	@OneToMany(mappedBy = "pasajero", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Destino> destino;  //Campo relacion 1:N	
}
