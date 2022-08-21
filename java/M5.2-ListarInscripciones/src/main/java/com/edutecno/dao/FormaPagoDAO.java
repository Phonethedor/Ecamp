package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.FormaPagoDTO;

//tiene la responsabilidad de acceder a la base de datos y consultar por las formas de pago
public class FormaPagoDAO {

	// metodo para consultar todas las formas de pago, los registros existentes en
	// la base de datos
	public List<FormaPagoDTO> obtieneFormasDePago() throws ClassNotFoundException, SQLException {

		// lista para agregar las formas de pago existentes
		List<FormaPagoDTO> listaFormaPago = new ArrayList<FormaPagoDTO>();

		// clase del driver de conexion ORACLE
		Class.forName("oracle.jdbc.OracleDriver");
		// URL de conexion para ORACLE
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EDUTECNO", "admin");

		// Class.forName("com.mysql.cj.jdbc.Driver");//MYSQL
		// URL de conexion para MYSQL
		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost/nombreDB?user=root&password=admin");
		
		try {
			//preparar la query con el PreparedStatement y la conexion
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM forma_pago");
			ResultSet rs = pstm.executeQuery(); //executeQuery() SELECT y retorna un ResultSet
			
			while (rs.next()) {//mientras el rs siga teniendo valores, que son los registros en cada fila
				//se instancia el objeto a construir mediante el ResultSet
				FormaPagoDTO formaPago = new FormaPagoDTO();
				formaPago.setIdFormaPago(rs.getString("id_forma_pago"));//entre comillas va el nombre de la columna
				formaPago.setDescripcion(rs.getString("descripcion"));
				formaPago.setRecargo(rs.getString("recargo"));
				
				listaFormaPago.add(formaPago);//se agrega la forma de pago a la lista para retornarla
			}
			
		} catch (Exception e) {
			e.printStackTrace();//impresion de la traza de error
		}
		return listaFormaPago;
	}
}
