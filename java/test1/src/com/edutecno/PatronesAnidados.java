package com.edutecno;
import java.util.Scanner;

public class PatronesAnidados {
public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Ingrese numero : ");
		int n = Integer.parseInt(sc.nextLine());
		
		cuadrado (n);
		zeta (n);
		equis (n);
		bloque (n);
		
	}	
	
	public static void cuadrado (int n) { 
         for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                	System.out.print("*");
                } else {
                	System.out.print(" ");
                }
            }
            System.out.println();
        }       
        System.out.println();
        
	}
    
	public static void zeta (int n) { 
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= n; j++) {
                 if (i == 1 || i == n || j == (n-(i-1))) {
                 	System.out.print("*");
                 } else {
                 	System.out.print(" ");
                 }
             }
             System.out.println();
         }
         
         System.out.println();
	}
	
	public static void equis (int n) { 
	         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= n; j++) {
                 if ((j == 1 && i == 1) || (j == n && i == n) || j == (n-(i-1)) || j == i)  {
                 	System.out.print("*");
                 } else {
                 	System.out.print(" ");
                 }
             }
             System.out.println();
         }
         
         System.out.println();
	}
	
	public static void bloque (int n) { 
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= n; j++) {
                 if ((i != n && j == n) || (i>1 && j==1)) {
                	System.out.print(" ");
                 } else {
                 	System.out.print("*");
                 }
             }
             System.out.println();
         }     
	}

}
