package com.edutecno.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.conection.AdministradorConexion;
import com.edutecno.interfaces.IPersonaDao;
import com.edutecno.model.Persona;

//PersonaDaoImp hereda desde AdministradorConexion e implementa la interfaz PersonaDao
public class PersonaDaoImp extends AdministradorConexion implements IPersonaDao {
	
	//constructor
	public PersonaDaoImp() {
		conn = generaPoolConexion();//obteniendo la conexion mediante el atributo y el metodo heredado
	}
	//metodo para consultar todas las personas
	@Override
	public List<Persona> findAll() {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			ps = conn.prepareStatement("SELECT * FROM persona");
			rs = ps.executeQuery();
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setName(rs.getString("name"));
				persona.setPassword(rs.getString("password"));
				persona.setEmail(rs.getString("email"));
				persona.setSex(rs.getString("sex"));
				persona.setCountry(rs.getString("country"));
				listaPersonas.add(persona);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPersonas;
	}
	//metodo para buscar persona por id
	@Override
	public Persona findById(int id) {
		Persona persona = new Persona();
		try {
				ps = conn.prepareStatement("SELECT * FROM persona WHERE id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {				
					persona.setId(rs.getInt("id"));
					persona.setName(rs.getString("name"));
					persona.setPassword(rs.getString("password"));
					persona.setEmail(rs.getString("email"));
					persona.setSex(rs.getString("sex"));
					persona.setCountry(rs.getString("country"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return persona;
	}
	//metodo para añadir persona
	@Override
	public boolean add(Persona persona) {
		boolean resul = true;
			
		try {											//INSERT INTO personas  VALUES (0,?,?,?,?) MYSQL
			ps = conn.prepareStatement("INSERT INTO persona  VALUES (persona_sec.NEXTVAL,?,?,?,?,?)");
			ps.setString(1, persona.getName());
			ps.setString(2, persona.getPassword());
			ps.setString(3, persona.getEmail());
			ps.setString(4, persona.getSex());
			ps.setString(5, persona.getCountry());
			
			if (ps.executeUpdate() == 1) {

				return true;
			} else {
				resul = false;
				throw new RuntimeException("Ha ocuriido un error insertando la persona.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resul = false;
		}
		return resul;
	}

	@Override
	public boolean update(Persona persona) {
		boolean resul = true;
		try {
			ps = conn.prepareStatement("UPDATE persona SET name=?,password=?,email=?,sex=?,country=? WHERE id=?");
			ps.setString(1, persona.getName());//primer ?
			ps.setString(2, persona.getPassword());//segundo ?
			ps.setString(3, persona.getEmail());//tercer ?
			ps.setString(4, persona.getSex());
			ps.setString(5, persona.getCountry());
			ps.setInt(6, persona.getId());
			if (ps.executeUpdate() == 1) {
				return resul;
			} else {
				resul = false; 
				throw new RuntimeException("Ha ocurido un error actualizando la persona.");
			}
		} catch (Exception e) {
			resul = false;
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean resul = true;
		try {
			ps = conn.prepareStatement("DELETE FROM persona WHERE id=?");
			ps.setInt(1, persona.getId());
			if (ps.executeUpdate() == 1) {
				return resul;
			} else {
				resul = false; 
				throw new RuntimeException("Ha ocurido un error al eliminar la persona.");
			}
		} catch (Exception e) {
			resul = false;
			e.printStackTrace();
		}
		return resul;
	}
}
