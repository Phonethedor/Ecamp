package com.edutecno;

import java.util.Scanner;

public class SumaImparLimite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int min, max, sumaImpar;
		System.out.print("Ingrese el limite inferior: ");
		min = Integer.parseInt(sc.nextLine());
		System.out.print("Ingrese el limite superior: ");
		max = Integer.parseInt(sc.nextLine());
		sumaImpar = 0;
		
		if (min < max) {
			do {
				if(min % 2 != 0) {
					sumaImpar += min;
				}
				
				min += 1;
				
			}while(min <= max);
		}else {
			System.out.println("el limite inferior es mayor al superior");
		}
		
		System.out.print(sumaImpar);
	}
}
