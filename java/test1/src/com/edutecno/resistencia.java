package com.edutecno;
import java.util.Scanner;

/*
  El programa deberá pedir 3 resistencias, calcular la resistencia total y mostrar el resultado
  en la consola. 
 */

public class resistencia {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float r1;
		float r2;
		float r3;
		float rt;
		
		System.out.println("---** Calculadora de resistencia **---");
		System.out.println("Ingrese el primer valor : ");
		r1 = Float.parseFloat(sc.nextLine());
		System.out.println("Ingrese el segundo valor : ");
		r2 = Float.parseFloat(sc.nextLine());
		System.out.println("Ingrese el tecter valor : ");
		r3 = Float.parseFloat(sc.nextLine());
		
		rt = 1 / ((1/r1)+ (1/r2)+ (1/r3));
		
		System.out.printf("La resistencia total es : %.2f", rt);
		
	}
	
}
