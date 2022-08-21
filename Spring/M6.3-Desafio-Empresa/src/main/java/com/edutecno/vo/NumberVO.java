package com.edutecno.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class NumberVO extends GenericVO {
	
	//atributo
	private long valor;

	public NumberVO(long valor,String mensaje, String codigo) {
		super(mensaje, codigo);
		this.valor = valor;
	}
}
