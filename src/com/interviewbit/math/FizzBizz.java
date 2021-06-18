package com.interviewbit.math;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FizzBizz {

	private static final Predicate<Integer> multipleOf3 = i -> i % 3 == 0;
	private static final Predicate<Integer> multipleOf5 = i -> i % 5 == 0;

	public static void main(String[] args) {
		System.out.println(fizzBuzz(5));
	}

	public static ArrayList<String> fizzBuzz(int A) {
		ArrayList<String> result = new ArrayList<>();
		int i = 1;
		while (i <= A) {
			if (multipleOf3.test(i) && multipleOf5.test(i)) {
				result.add("FizzBuzz");
			} else if (multipleOf3.test(i) && !multipleOf5.test(i)) {
				result.add("Fizz");
			} else if (!multipleOf3.test(i) && multipleOf5.test(i)) {
				result.add("Buzz");
			} else {
				result.add(i+"");
			}
			i++;
		}
		return result;
	}

}
