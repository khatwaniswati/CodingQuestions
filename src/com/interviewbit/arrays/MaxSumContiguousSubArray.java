package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubArray {
	public static void main(String[] args) {
		/*
		 * int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		 * System.out.println(maxSubArraySum(arr, arr.length));
		 * 
		 * System.out.println(maxSubArray(Arrays.asList(1, 2, 3, 4, -10)));
		 * System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5,
		 * 4)));
		 */
		System.out.println(maxSubArray(Arrays.asList(-163, -20)));

	}

	public static int maxSubArray(final List<Integer> A) {
		int max_so_far = A.get(0);
		int curr_max = A.get(0);

		for (int i = 1; i < A.size(); i++) {
			curr_max = Math.max(A.get(i), curr_max + A.get(i));
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;

	}

	private static int maxSubArraySum(int a[], int size) {

		int max_so_far = a[0], max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;

			/*
			 * Do not compare for all elements. Compare only when max_ending_here > 0
			 */
			else if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;

		}
		return max_so_far;
	}

}
