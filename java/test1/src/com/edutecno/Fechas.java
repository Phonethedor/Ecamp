package com.edutecno;
import java.util.Scanner;

public class Fechas {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String fecha1, fecha2;
		int anio1, mes1, dia1, anio2, mes2, dia2;
		
		System.out.println("***** Calculadora de Fechas *****");
		System.out.print("Ingrese la primera fecha en formato DD/MM/AAAA : ");
		fecha1 = sc.nextLine();
		dia1 = Integer.parseInt(fecha1.substring(0,2));
		mes1 = Integer.parseInt(fecha1.substring(3,5));
		anio1 = Integer.parseInt(fecha1.substring(7,10));
		
		System.out.print("Ingrese la segunda fecha en formato DD/MM/AAAA : ");
		fecha2 = sc.nextLine();
		dia2 = Integer.parseInt(fecha2.substring(0,2));
		mes2 = Integer.parseInt(fecha2.substring(3,5));
		anio2 = Integer.parseInt(fecha2.substring(7,10));
		
		if (anio1 < anio2) {
			System.out.println("La segunda persona es mayor");
		} else if (anio2 < anio1) {
			System.out.println("La primera persona es mayor");
		} else {
			if (mes1 < mes2) {
				System.out.println("La segunda persona es mayor");
			} else if (mes2 < mes1) {
				System.out.println("La primera persona es mayor");
			} else {
				if (dia1 < dia2) {
					System.out.println("La segunda persona es mayor");
				} else if (dia2 < dia1) {
					System.out.println("La primera persona es mayor");
				} else {
					System.out.println("Tienen la misma edad");
				}
			}
		}
	}
}
