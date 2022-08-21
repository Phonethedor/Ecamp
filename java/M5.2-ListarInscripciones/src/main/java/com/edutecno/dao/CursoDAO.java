package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.CursoDTO;

//DATA ACCESS OBJECT, 
//objeto que contiene los metodos para acceder mediante una conexion a la BBDD
public class CursoDAO {

	//List<CursoDTO>findAll()
	//CursoDTO findById(int id)
	//CursoDTO add(CursoDTO cursoDTO)/boolean save(CursoDTO cursoDTO)
	//CursoDTO update(CursoDTO cursoDTO)/boolean update(CursoDTO cursoDTO)
	//boolean delete(int id)/int delete(CursoDTO cursoDTO)
	//findByNameAndPassword(String name, String password);
	
	//metodo para obtener todos los cursos existentes en la base de datos
	public List<CursoDTO> obtieneCursos() throws ClassNotFoundException, SQLException{
		
		//lista para almacenar los cursos obtenidos de la consulta
		List<CursoDTO> listaCursos = new ArrayList<CursoDTO>();
		
		//clase del driver de conexion ORACLE
		Class.forName("oracle.jdbc.OracleDriver");	
		//URL de conexion para ORACLE
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EDUTECNO", "admin");
		
		//Class.forName("com.mysql.cj.jdbc.Driver");//MYSQL
		//URL de conexion para MYSQL
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/nombreDB?user=root&password=admin");
		
		try {
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM curso");
			ResultSet rs = pstm.executeQuery(); //executeQuery() se utiliza para los SELECT
			
			while (rs.next()) {//si ResultSet contiene elementos se creean los objetos CursoDTO
				CursoDTO curso = new CursoDTO();//objeto para setear los valores obtenidos de la base de datos
				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setDescripcion(rs.getString("descripcion"));
				curso.setPrecio(rs.getInt("precio"));
				
//				CursoDTO cursoDTO = new CursoDTO(
//						rs.getInt("id_curso"),
//						rs.getString("descripcion"),
//						rs.getInt("precio")
//						);
				
				listaCursos.add(curso);//se añade el curso a la lista existente
			}
		} catch (Exception e) {
			e.printStackTrace();//impresion de la traza de error
//			System.out.println(e.getMessage());
		}finally {
			conn.close();//cerrar conexion
		}
		return listaCursos;
	}
}
