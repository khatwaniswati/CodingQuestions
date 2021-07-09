package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<>(Arrays.asList(2, 8, 10, 9, 5, 6, 1, 3, 11))));
		System.out.println(solve(new ArrayList<>(Arrays.asList(3, 2, 1, 3))));
		System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1, 3, 3))));
	}

	public static int solve(ArrayList<Integer> A) {
		int[] countArr = new int[A.size() + 1];
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) < 0)
				continue;
			else if (A.get(i) >= A.size())
				countArr[A.size()] += 1;
			else
				countArr[A.get(i)] += 1;
		}
		// System.out.println(Arrays.toString(countArr));

		int total = countArr[A.size()];
		// System.out.println(total);
		for (int i = countArr.length - 2; i >= 0; i--) {
			if (countArr[i] > 0 && total == i)
				return 1;
			else if (total > i)
				break;
			else
				total += countArr[i];
		}
		return -1;
	}

	public static int solveCopied(ArrayList<Integer> A) {
		// Total runtime: O(n log n) due to sort
		Collections.sort(A);

		for (int i = 0; i < A.size(); i++) {
			// Handle duplicates (only check for rightmost duplicate), skip others
			if (i < A.size() - 1 && A.get(i) == A.get(i + 1)) {
				continue;
			}
			// Check if the remaining values to the right are equal to the current value
			if (A.size() - i - 1 == A.get(i)) {
				return 1;
			}
		}

		return -1;
	}

}
