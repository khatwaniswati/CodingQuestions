package com.interviewbit;
import java.lang.reflect.Method;
import java.util.Arrays;

class Printer {

	public void printArray(Object[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
	}

}

/***** Don't change anything in the code below *****/
public class GenericsDemo {
	public static void main(String[] args) {
		
		Object [] myObjects = {
				
				new Integer(3),
				new String("s")
		};
		Arrays.sort(myObjects);
		Printer myPrinter = new Printer();
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		int count = 0;

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.equals("printArray"))
				count++;
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");

	}
}