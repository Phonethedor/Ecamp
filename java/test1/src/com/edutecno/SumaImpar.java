package com.edutecno;
import java.util.Scanner;

public class SumaImpar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c, n, sumaImpar;
		System.out.print("Ingrese la cantidad de numeros pares a mostrar: ");
		n = Integer.parseInt(sc.nextLine());
		c = 1;
		sumaImpar = 0;
		
		do {
			if (c % 2 != 0) {
				sumaImpar = sumaImpar + c;
			}
			
			c += 1;
		}while (c <= n);
		
		System.out.print(sumaImpar);
	}
}
