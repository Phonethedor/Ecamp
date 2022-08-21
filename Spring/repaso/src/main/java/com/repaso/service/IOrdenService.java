package com.repaso.service;

import java.util.List;
import com.repaso.dto.Orden;

public interface IOrdenService {
	
	public List<Orden> listarOrdenes();
	public List<Orden> listarOrdenesFiltradasPorTienda(Integer storeId);
	public List<Orden> listarOrdenesFiltradasPorEstado(Integer orderStatus);
	public List<Orden> listarOrdenesFiltroPorTiendaYEstado(Integer storeId, Integer orderStatus);
	public List<Orden> listarOrdenesFiltroCompletado(Integer storeId, Integer orderStatus);
	
}
