package com.edutecno.vo;

import java.util.List;

import com.edutecno.model.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoVO extends GenericVO {
	
	//atributos
	private List<Producto> productos;

	public ProductoVO(List<Producto> productos,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.productos = productos;
	}
}
