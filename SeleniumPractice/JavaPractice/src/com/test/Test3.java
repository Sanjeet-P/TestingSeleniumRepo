package com.test;

public class Test3 {

	public static void main(String[] args) {
		System.out.println("Main  method execution start");
		test1();
		test2();
		System.out.println("Main method execution finished");
		
		
	}
public static void test1() {
	System.out.println("Test1 method executed ");
	
}

public static void test2() {
	System.out.println("Test2 Method executed ");
	test3();
}
public static void test3() {
	System.out.println("Test3 Method executed");
}
}
