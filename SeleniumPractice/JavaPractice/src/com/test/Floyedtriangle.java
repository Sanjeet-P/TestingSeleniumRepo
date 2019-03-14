package com.test;

import java.util.Scanner;

public class Floyedtriangle {

	public static void main(String[] args) {
		
		int num=1, row,counter,j;
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter the number of rows = " );
		row=input.nextInt();
		
		System.out.println("Floyed Triangle ");
		System.out.println("***************");
		
		for(counter=1;counter<=5;counter++) {
			
			for(j=1; j<=counter; j++) {
				System.out.print(num+ " ");
				num++;
			}
			System.out.println(" ");
		}
	}

}
