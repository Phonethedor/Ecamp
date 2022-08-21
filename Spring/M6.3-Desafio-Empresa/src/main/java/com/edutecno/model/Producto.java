package com.edutecno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "SQ_PRODUCTO", initialValue = 1, allocationSize = 1, sequenceName = "SQ_PRODUCTO")// Oracle
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCTO")// Oracle JPA
	//GeneratedValue(strategy = GenerationType.IDENTITY)// MySQL JPA
	private Integer IdProducto;
	@Column(unique = true, nullable = false)
	private String codigo;
	@Column(unique = true, nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Integer precio;
	@Column(nullable = false)
	private Integer stock;
}
