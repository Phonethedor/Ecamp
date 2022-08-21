package com.edutecno;
import java.util.Scanner;

public class SoloPares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c, n, cp;
		System.out.print("Ingrese la cantidad de numeros pares a mostrar: ");
		n = Integer.parseInt(sc.nextLine());
		c = 0;
		cp = 1;
		
		do {
			if (c % 2 == 0) {
				System.out.println(c);
				cp += 1;
			}
			
			c += 1;
		}while (cp <= n);
	}
}
