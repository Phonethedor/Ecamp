package com.edutecno;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numero,fib1,fib2,i;
		  
        do{
            System.out.print("Introduce numero mayor que 1: ");
            numero = sc.nextInt();
        }while(numero<=1);                

        fib1 = 1;
        fib2 = 1;

        System.out.println(fib1);
        for(i=2;i<=numero;i++){
            System.out.println(fib2);
            fib2 = fib1 + fib2;
            fib1 = fib2 - fib1;
        }
	}
}
