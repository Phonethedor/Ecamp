package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.DepartamentoEmpleado;

public interface DepartamentoEmpleadoDao {
	List<DepartamentoEmpleado> obtieneDepartamento (String nomDepto);
}
