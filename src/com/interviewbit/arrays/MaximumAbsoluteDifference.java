package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		System.out.println(maxDistance(new ArrayList<>(Arrays.asList(1, 3, -1))));
	}

	private static int maxDistance(ArrayList<Integer> A) {
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		return Math.max(max1 - min1, max2 - min2);
	}
}