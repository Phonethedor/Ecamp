package com.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.Application;
import com.edutecno.model.Producto;
import com.edutecno.repository.ProductoRepository;
import com.edutecno.vo.NumberVO;
import com.edutecno.vo.ProductoVO;

@Service
public class ProductoServiceImp implements ProductoService {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired
	ProductoRepository dao;	
	ProductoVO respuesta;
	
	@Override
	@Transactional(readOnly = true)
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setProductos((List<Producto>) dao.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProductos().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en getAllProductos", e);
		}
		return respuesta;
	}

	@Transactional
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "104");
		try {
			dao.save(producto);
			respuesta.setMensaje(String.format("Se ha guardado correctamente el producto %s", producto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en add", e);
		}
		return respuesta;
	}

	@Transactional
	public ProductoVO update(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "105");
		try {
			dao.save(producto);
			respuesta.setMensaje(String.format("Se ha actualizado correctamente el producto %s", producto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "106");
		try {
			dao.delete(producto);
			respuesta.setMensaje("Se ha eliminado correctamente el producto");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en delete", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findById(Integer id) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "107");
		try {
			Producto usuario = dao.findById(id).get();
			respuesta.getProductos().add(usuario);
			respuesta.setMensaje("Producto encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en findById", e);
		}
		return respuesta;
	}
	
	
	//Segunda Parte
	@Override
	@Transactional(readOnly = true)
	public ProductoVO getPage(Integer pagina, Integer cantidad) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "108");
		try {
			Pageable pageable = PageRequest.of(pagina, cantidad);
			Page<Producto> responsePage = dao.findAll(pageable);
			respuesta.setProductos(responsePage.getContent());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProductos().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en getPage", e);
		}
		return respuesta;
	}
	
	@Override
	@Transactional(readOnly = true)
	public NumberVO getPageCount(long registrosPorPagina) {
		NumberVO respuesta = new NumberVO(0, "Ha ocurrido un error", "109");
		try {
			long registros = dao.count();
			if (registrosPorPagina == 0 && registros == 0) {
				respuesta.setValor(1);
			} else {
				respuesta.setValor((registros / registrosPorPagina) + (registros % registrosPorPagina == 0 ? 0 : 1));
			}
			respuesta.setCodigo("201");
			respuesta.setMensaje(String.format("Hay %d paginas", respuesta.getValor()));
		} catch (Exception e) {
			log.trace("Producto Service: Error en getPageCount", e);
		}
		return respuesta;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByNombreContainingIgnoreCase(String nombre) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "101");
		try {
			List<Producto> usuarios = dao.findByNombreContainingIgnoreCase(nombre);
			if (usuarios.size() > 0) {
				respuesta.setProductos(usuarios);
				respuesta.setMensaje("Producto encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Producto no encontrado.");
			}
		} catch (Exception e) {
			log.trace("Producto Service: Error en findByNombreContainingIgnoreCase", e);
		}
		return respuesta;
	}
}
