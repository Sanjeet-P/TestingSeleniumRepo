package com.test;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		int num;
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the number = ");
		num=scan.nextInt();
		
		scan.close();
		
		System.out.println("Given number is = " +num);
	}

}
