package com.test;

public class Test4 {

	public static void main(String[] args) {
		System.out.println("Execution begins");
		function1();
		System.out.println("Execution Ends");

	}

	public static void function1() {
		for(int i=10;i<=20;i++) {
			if(i%2==0) {
				
				System.out.println("The even numbers are = " +i);
			}
		}
	}
}
