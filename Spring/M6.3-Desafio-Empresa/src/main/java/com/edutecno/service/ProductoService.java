package com.edutecno.service;

import com.edutecno.model.Producto;
import com.edutecno.vo.NumberVO;
import com.edutecno.vo.ProductoVO;

public interface ProductoService {
	
	public ProductoVO getAllProductos();	
	public ProductoVO add(Producto producto);
	public ProductoVO update(Producto producto);
	public ProductoVO delete(Producto producto);
	public ProductoVO findById(Integer id);
	public ProductoVO getPage(Integer pagina, Integer cantidad);
	public ProductoVO findByNombreContainingIgnoreCase(String nombre);
	public NumberVO getPageCount(long registrosPorPagina);		
}
