package com.edutecno;
import java.util.Scanner;

public class Patrones {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Ingrese numero : ");
		int n = Integer.parseInt(sc.nextLine());
		
		asteriscoPunto (n);
		unoHastaCuatro (n);
		doblePipeAsterico (n);
				
	}	
		
	public static void asteriscoPunto (int n) { 	
		for (int i = 0; i < n ; i++) {
			String x = (i % 2 == 0) ?  "*" : ".";
			System.out.print(x);
		}
		System.out.println();
	}
	
	public static void unoHastaCuatro (int n) {
		int j = 1;
		
		for (int i = 0; i < n ; i++) {
			System.out.print(j);
			j ++;
			if (j == 5) j = 1;
		}
		System.out.println();
	}
	
	public static void doblePipeAsterico (int n) {		
		for (int i = 0; i < n ; i++) {
			String x = (i % 2 == 0) ?  "||" : "*";
			System.out.print(x);
		}
		System.out.println();
	}

}
