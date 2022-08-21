package com.alvaro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Estudiante {
	
	private Integer id_estudiante;
	private String rut;
	private String apellido_pat;
	private String apellido_mat;
	private String direccion;
	private String fecha_nacimiento;
	
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Estudiante() {
		
	}

	public Estudiante(Integer id_estudiante, String rut, String apellido_pat, String apellido_mat, String direccion,
			String fecha_nacimiento) {
		super();
		this.id_estudiante = id_estudiante;
		this.rut = rut;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getApellido_pat() {
		return apellido_pat;
	}

	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}

	public String getApellido_mat() {
		return apellido_mat;
	}

	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public int calcularEdad(String fecha) {
		String fecha_nac = fecha;
		Integer dia_nac = Integer.parseInt(fecha_nac.substring(0, 2));
		Integer mes_nac = Integer.parseInt(fecha_nac.substring(3,5));
		Integer anio_nac = Integer.parseInt(fecha_nac.substring(6,10));
		
		LocalDate hoy = LocalDate.now();
		String hoyS = hoy.format(formato);
		Integer dia = Integer.parseInt(hoyS.substring(0, 2));
		Integer mes = Integer.parseInt(hoyS.substring(3,5));
		Integer anio = Integer.parseInt(hoyS.substring(6,10));
		int edad = 0 ;
		
		if(anio_nac < anio && mes_nac < mes) {
			edad = anio - anio_nac;
		}else if(mes_nac == mes && dia_nac <= dia) {
			edad = anio - anio_nac;
		}else if(mes_nac > mes) {
			edad = anio - anio_nac - 1;
		}else {
			System.out.println( "fecha de nacimiento erronea, ingresar con formato dd/MM/yyyy (/ incluidos)");
			
		}
		
		return edad;
	}
}
