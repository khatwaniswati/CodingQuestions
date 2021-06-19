package com.interviewbit.arrays;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class MinStepInInfiniteGrid {
	static int result = 0;

	public static void main(String[] args) {
		// int coverPoints = coverPoints(new ArrayList<>(Arrays.asList(-7,-13)), new
		// ArrayList<>(Arrays.asList(1,-5)));//output=6
		/*
		 * A : [ 4, 8, -7, -5, -13, 9, -7, 8 ] B : [ 4, -15, -10, -3, -13, 12, 8, -8 ]
		 */
		// int coverPoints = coverPoints(new ArrayList<>(Arrays.asList(0, 1, 1)), new
		// ArrayList<>(Arrays.asList(0, 1, 2)));
		int coverPoints = coverPoints(new ArrayList<>(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8)),
				new ArrayList<>(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8)));
		System.out.println(coverPoints);
	}

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		if (A.size() == 1)
			return 0;
		List<Entry<Integer, Integer>> lst = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			lst.add(new AbstractMap.SimpleEntry<Integer, Integer>(A.get(i), B.get(i)));
		}
		System.out.println(lst);
		IntStream.range(0, lst.size() - 1).forEach(i -> {
			getSteps(lst.get(i), lst.get(i + 1));
		});
		return result;
	}

	public static void getSteps(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
		//System.out.println(e2.getKey() + " " + e1.getKey() + " " + e2.getValue() + " " + e1.getValue());
		//System.out.println(Math.max(Math.abs(e2.getKey() - e1.getKey()), Math.abs(e2.getValue() - e1.getValue())));
		result += Math.max(Math.abs(e2.getKey() - e1.getKey()), Math.abs(e2.getValue() - e1.getValue()));
		/*
		 * return new AbstractMap.SimpleEntry<Integer, Integer>(
		 * Math.max(Math.abs(e2.getKey() - e1.getKey()), Math.abs(e2.getValue() -
		 * e1.getValue())), 0);
		 */

	}
}
