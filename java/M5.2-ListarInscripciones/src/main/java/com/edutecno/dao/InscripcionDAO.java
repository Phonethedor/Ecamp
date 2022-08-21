package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.InscripcionDTO;

//tendra la responsabilidad de obtener todas las inscripciones, los registros existentes
//responsabilidad de insertar las inscripciones
public class InscripcionDAO {
	
	// metodo para insertar una inscripcion en la base de datos
	public InscripcionDTO insertarInscripciones(InscripcionDTO inscripcionDTO)
			throws ClassNotFoundException, SQLException {

		int maxId = 0;

		// clase del driver de conexion ORACLE
		Class.forName("oracle.jdbc.OracleDriver");
		// URL de conexion para ORACLE
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EDUTECNO", "admin");

		// Class.forName("com.mysql.cj.jdbc.Driver");//MYSQL
		// URL de conexion para MYSQL
		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost/nombreDB?user=root&password=admin");

		String consultaProximoId = "SELECT MAX(id_inscripcion) FROM inscripcion";

		try {
			// (id_inscripcion,nombre,telefono,id_curso,id_forma_pago)
			PreparedStatement pstm = conn
					.prepareStatement("INSERT INTO inscripcion VALUES(inscripcion_sec.NEXTVAL,?,?,?,?)");
			// seteando los valores para los signos de interrogacion o parametros argumentos
			// en la query
			// tienen orden de inserccion, y el indice comienza desde 1
			pstm.setString(1, inscripcionDTO.getNombre());
			pstm.setString(2, inscripcionDTO.getTelefono());
			pstm.setInt(3, inscripcionDTO.getIdCurso());
			pstm.setInt(4, inscripcionDTO.getIdFormaPago());

			if (pstm.executeUpdate() == 1) {// si executeUpdate() retorna 1, la query se ejecuto, si retorna 0 no se
											// ejecuto
				pstm = conn.prepareStatement(consultaProximoId);// preparando la query para el max id
				ResultSet rs = pstm.executeQuery();// ejecutando la query del max id

				if (rs.next()) {// verificando si tenemos datos en el ResultSet
					maxId = rs.getInt(1);// seteando el resultado en una variable
					inscripcionDTO.setIdInscripcion(maxId);// seteo del id de la inscripcion que se genero en la base de
															// datos
				}
			} else {
				// se genera un error de excepcion si ocurre un error en el ingreso
				throw new RuntimeException("Ha ocurrido un error insertando la inscripcion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inscripcionDTO;
	}

	// metodo encargado de consultar por todos los registros de inscripcion
	// existentes
	public List<InscripcionDTO> obtieneInscripciones() throws ClassNotFoundException, SQLException {

		// lista para almacenar todos los registros obtenidos de la consulta a la base
		// de datos
		List<InscripcionDTO> listaInscripciones = new ArrayList<InscripcionDTO>();

		// clase del driver de conexion ORACLE
		Class.forName("oracle.jdbc.OracleDriver");
		// URL de conexion para ORACLE
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EDUTECNO", "admin");

		// Class.forName("com.mysql.cj.jdbc.Driver");//MYSQL
		// URL de conexion para MYSQL
		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost/nombreDB?user=root&password=admin");
		
		try(PreparedStatement pstm = conn.prepareStatement("SELECT * FROM inscripcion");) {
			
			ResultSet rs = pstm.executeQuery();//SELECT executeQuery() para las consultas
			
			while (rs.next()) {//verificando si existen datos en la fila, registros en la base de datos
				InscripcionDTO inscripcion = new InscripcionDTO();//objeto que en cada ciclo se resetea
				inscripcion.setIdInscripcion(rs.getInt("id_inscripcion"));
				inscripcion.setNombre(rs.getString("nombre"));
				inscripcion.setTelefono(rs.getString("telefono"));
				inscripcion.setIdCurso(rs.getInt("id_curso"));
				inscripcion.setIdFormaPago(rs.getInt("id_forma_pago"));
				
				//guardar el objeto dentro de la lista
				listaInscripciones.add(inscripcion);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaInscripciones;
	}
}
