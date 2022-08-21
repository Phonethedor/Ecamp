package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.connection.AdministradorConexion;
import com.edutecno.interfaces.CategoriaDao;
import com.edutecno.model.Categoria;

public class CategoriaDaoImp extends AdministradorConexion implements CategoriaDao {
	
	public CategoriaDaoImp() {
		conn = generaPoolConexion();
	}
	
	//buscar categoria por id, consultar la categoria en la base de datos por un id
	@Override
	public Categoria findById(int id) {
		
		Categoria categoria = new Categoria();//categoria que se retornara que fue consultada a la base de datos
		try {
			ps = conn.prepareStatement("SELECT * FROM categoria WHERE id_categoria=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
			}
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//buscar todas las categorias en la base de datos
	@Override
	public List<Categoria> findAll() {
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM categoria");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				
				listaCategorias.add(categoria);
			}
			return listaCategorias;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Categoria>();
	}
}
