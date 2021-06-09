package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class LargestNumber {
	static Comparator<String> mycomp = (a, b) -> (b + "" + a).compareTo(a + "" + b);

	public static void main(String[] args) {
		// 3, 30, 34, 5, 9
		// 8,89
		// 27,271
		// 0, 0, 0, 0
		System.out.println(largestNumber(Arrays.asList(97750768, 60243460)));
	}

	public static String largestNumber(final List<Integer> A) {
		String collect = A.stream().filter(i -> i != 0).map(Object::toString).sorted(mycomp)
				.collect(Collectors.joining());
		return collect.isEmpty() ? "0" : collect;
	}

}
