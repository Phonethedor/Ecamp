package cl.edutecno.hibernateDto.modelEntidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity//etiqueta para indicar que el objeto es una entidad correspondiente a la base de datos
@Table(name ="curso")//etiqueta para indicar la tabla que se quiere mapear ORM
public class Curso {
	
	private int idCurso;//atributos del objeto
	private String descripcion;
	private double precio;
	
	@Id//etiqueta indicando cual es el id
	@Column(name = "id_curso")//etiqueta para indicar la columna
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_sec")//forma de generación del id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL
	@SequenceGenerator(name = "curso_sec", sequenceName = "curso_sec", allocationSize = 1)//secuencia que lo generara
	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	@Basic//etiqueta para indicar que es un dato basico en java
	@Column(name = "descripcion")//etiqueta para indicar la columna de la tabla
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Basic
	@Column(name = "precio")
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
}
