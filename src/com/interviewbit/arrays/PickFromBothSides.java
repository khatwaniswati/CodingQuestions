package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 2));
	}

	public static int solve(ArrayList<Integer> A, int B) {
		/*
		 * Deque<Integer> dq1 = new ArrayDeque<Integer>(B); int sum = 0; for (int i = 0;
		 * i < B; i++) { sum += A.get(i); dq1.addLast(A.get(i)); } int max =
		 * Integer.MIN_VALUE; int n = A.size() - 1; for (int i = 0; i < B; i++) { max =
		 * Math.max(max, sum); sum = sum - dq1.removeLast(); sum = sum + A.get(n - i);
		 * dq1.addFirst(A.get(n - i)); } return max;
		 */
		int n = A.size();

		int result = 0;

		for (int i = 0; i < B; i++) {
			result += A.get(i);
		}

		int sum = result;

		for (int i = 0; i < B; i++) {
			sum -= A.get(B - 1 - i);
			sum += A.get(n - 1 - i);

			result = Math.max(result, sum);
		}

		return result;
	}

}
