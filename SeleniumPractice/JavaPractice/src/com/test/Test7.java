//Method Overloading

package com.test;

class ABC{
	public void test1(int n){
		System.out.println("This is a single argument method");
	
		}
	public void test1(int n1, int n2) {
		System.out.println("This is a two  argument method");
	}
	public void test1(int n1, int n2, int n3) {
		System.out.println("This is three argument method");
	}
}

public class Test7 {

	public static void main(String[] args) {
		ABC a1=new ABC();
	    a1.test1(10,20);
	    a1.test1(10);
	    a1.test1(10,20,30);
	
	}

}
