package com.alvaro;
import java.util.Scanner;

public class DemoConsola {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Estudiante estudiante1 = new Estudiante(1, "11", "apellidoP1", "apellidoM1", "direccion1", "");
		Estudiante estudiante2 = new Estudiante(2,"22","apellidoP2", "apellidoM2", "direccion2", "");
		Estudiante estudiante3 = new Estudiante(3, "33", "apellidoP3", "apellidoM3", "direccion3", "");
		Estudiante estudiante4 = new Estudiante(4, "44", "apellidoP4", "apellidoM4", "direccion4", "");
		Estudiante estudiante5 = new Estudiante(5, "55", "apellidoP5", "apellidoM5", "direccion5", "");
	
		System.out.println("Ingrese la fecha de nacimiento para el primer estudiante (Formato dd/MM/yyyyy) :");
		estudiante1.setFecha_nacimiento(sc.next());
		System.out.println("Ingrese la fecha de nacimiento para el segundo estudiante (Formato dd/MM/yyyyy) :");
		estudiante2.setFecha_nacimiento(sc.next());
		System.out.println("Ingrese la fecha de nacimiento para el tercer estudiante (Formato dd/MM/yyyyy) :");
		estudiante3.setFecha_nacimiento(sc.next());
		System.out.println("Ingrese la fecha de nacimiento para el cuarto estudiante (Formato dd/MM/yyyyy) :");
		estudiante4.setFecha_nacimiento(sc.next());
		System.out.println("Ingrese la fecha de nacimiento para el quinto estudiante (Formato dd/MM/yyyyy) :");
		estudiante5.setFecha_nacimiento(sc.next());
		System.out.println("La edad del primer estudiante es: "+estudiante1.calcularEdad(estudiante1.getFecha_nacimiento()));
		System.out.println("La edad del segundo estudiante es: "+estudiante2.calcularEdad(estudiante2.getFecha_nacimiento()));
		System.out.println("La edad del tercer estudiante es: "+estudiante3.calcularEdad(estudiante3.getFecha_nacimiento()));
		System.out.println("La edad del cuarto estudiante es: "+estudiante4.calcularEdad(estudiante4.getFecha_nacimiento()));
		System.out.println("La edad del quinto estudiantes es: "+estudiante5.calcularEdad(estudiante5.getFecha_nacimiento()));
		
		sc.close();
	}

}
