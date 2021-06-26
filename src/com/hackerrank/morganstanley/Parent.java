package com.hackerrank.morganstanley;

public class Parent {

	private void display() {
		System.out.println("In Parent");
	}
}

class Child extends Parent {

	public void display() {
		System.out.println("In Child");
	}
}

class Test {
	public static void main(String[] args) {
		Parent p = new Child();
		// p.display();
	}
}