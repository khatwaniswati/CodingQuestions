package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {
	public static void main(String[] args) {
		// 1, 2, 3, 4, -5 B=10
		// -1,2,1,-4 B=1
		// -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1,
		// -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9,
		// 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 B=-1
		// 2147483647, -2147483648, -2147483648, 0, 1 B=0
		System.out.println(
				threeSumClosest(new ArrayList<>(Arrays.asList(2147483647, -2147483648, -2147483648, 0, 1)), 0));

	}

	public static int threeSumClosest(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int closestSum = Integer.MAX_VALUE;
		for (int i = 0; i < A.size() - 2; i++) {// 3 elements sum so last element should have index n-3
			int ptr1 = i + 1;
			int ptr2 = A.size() - 1;

			while (ptr1 < ptr2) {
				int sum = A.get(i) + A.get(ptr1) + A.get(ptr2);
				if (abs(B - sum) < abs(B - closestSum)) {
					closestSum = sum;
				}
				if (sum > B)
					ptr2--;
				else
					ptr1++;
			}
		}
		return closestSum;
	}

	private static long abs(int i) {
		return Math.abs((long) i);
	}
}
