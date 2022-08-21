package com.alvaro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LibroVenta {

	private String nombreVenta;
	private String fechaVenta;
	
	public LibroVenta() {
		super();
	}	
	
	public LibroVenta(String nombreVenta, String fechaVenta) {
		super();
		this.nombreVenta = nombreVenta;
		this.fechaVenta = fechaVenta;
	}

	public String getNombreVenta() {
		return nombreVenta;
	}

	public void setNombreVenta(String nombreVenta) {
		this.nombreVenta = nombreVenta;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public void guardarVenta(Cliente cliente, Vehiculo vehiculo) {
		crearDirectorio("ficheros");
		System.out.println("Cliente Edad   : " + cliente.getEdad());
		System.out.println("Cliente Nombre : " + cliente.getNombre());
		boolean creado = crearArch("LibroVentas.txt");
		if (creado) {
			try {
			    File arch = new File ("src/ficheros/LibroVentas.txt");	
				FileWriter escribir = new FileWriter(arch);
				BufferedWriter buffer = new BufferedWriter(escribir);
				
				buffer.write(this.nombreVenta + " , " + this.fechaVenta);
				buffer.newLine();
				buffer.write(vehiculo.getPatente());
				buffer.newLine();
				buffer.write(String.valueOf(cliente.getEdad()));			
				buffer.close();
				escribir.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getCause());
			}			
		}		
	}
		
	private static void crearDirectorio(String nomDir) {		
		File subdir = new File ("src/"+nomDir);
		
		if(subdir.exists()) {
			System.out.println("El directorio o carpeta existe.");
		} else {
			subdir.mkdir(); // Crea un directorio
			System.out.println("El directorio ha sido creado.");
		}
	}
	
	public static boolean crearArch(String nomArch) {
		//Object iden = new Object();
		boolean resp = false;
		try {
			File arch = new File ("src/ficheros/"+nomArch);
			if(!arch.exists()) {
				arch.createNewFile();
				System.out.println("Archivo creado.");
			} else {
				System.out.println("Archivo existe.");
			}
			resp = true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		return resp; 
	}
	
	@Override
	public String toString() {
		return "LibroVenta [nombreVenta=" + nombreVenta + ", fechaVenta=" + fechaVenta + "]";
	}
	
}
