package com.repaso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.dao.OrdenRepository;
import com.repaso.dto.Orden;

@Service
public class OrdenServiceImpl implements IOrdenService{

	@Autowired
	private OrdenRepository ordenRepository;
		
	@Override
	public List<Orden> listarOrdenes() {
		return ordenRepository.listarOrdenes();
	}

	@Override
	public List<Orden> listarOrdenesFiltradasPorTienda(Integer storeId) {
		return ordenRepository.listarOrdenesPorTienda(storeId);
	}

	@Override
	public List<Orden> listarOrdenesFiltradasPorEstado(Integer orderStatus) {
		return ordenRepository.listarOrdenesPorEstado(orderStatus);
	}

	@Override
	public List<Orden> listarOrdenesFiltroPorTiendaYEstado(Integer storeId, Integer orderStatus) {
		return ordenRepository.listarOrdenesFiltroPorTiendaYEstado(storeId, orderStatus);
	}
	
	public List<Orden> listarOrdenesFiltroCompletado(Integer storeId, Integer orderStatus){
		if (storeId != 0 && orderStatus == 0) {
			return ordenRepository.listarOrdenesPorTienda(storeId);
		} else if (storeId == 0 && orderStatus !=0) {
			return ordenRepository.listarOrdenesPorEstado(orderStatus);
		} else if (storeId != 0 && orderStatus !=0){
			return ordenRepository.listarOrdenesFiltroPorTiendaYEstado(storeId, orderStatus);
		} else {
			return ordenRepository.listarOrdenes();
		}
	}

}
