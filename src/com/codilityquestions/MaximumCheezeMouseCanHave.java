package com.codilityquestions;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumCheezeMouseCanHave {

	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// for taking count of test-cases
		int t = sc.nextInt();

		// for storing the input array for each test-case
		int[][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			result[i] = arr;
		}
		sc.close();

		// calculating the max cheeze that mouse can have for each test-case one by one
		for (int i = 0; i < t; i++) {
			maxSum = Integer.MIN_VALUE;
			maxCheezeMouseCanHave(result[i], 0);
			System.out.println(maxSum);
		}

	}

	private static void maxCheezeMouseCanHave(int[] subList, int count) {
		// if arr is null or empty , then updating the current max weight count if it is
		// less than maxSum i.e already calculated sum considering different options
		if (subList == null || subList.length == 0) {
			if (maxSum < count)
				maxSum = count;
		} else {
			// if sub-array size becomes 2 , choosing the max from available 2 options
			if (subList.length == 2) {
				count += Math.max(subList[0], subList[1]);
				maxCheezeMouseCanHave(null, count);
			} else if (subList.length == 1) { // if sub-array size becomes 1, choose
				count += subList[0];
				maxCheezeMouseCanHave(null, count);
			} else {
				if (subList.length > 2) {
					// dividing arr to sub-array considering 0th index as 1st option and recursively
					// calling it till there is 0 element left in the sub-array
					int[] subSubList = Arrays.copyOfRange(subList, 2, subList.length);
					maxCheezeMouseCanHave(subSubList, count + subList[0]);

					// dividing arr to sub-array considering 1st index as 1st option and recursively
					// calling it till there is 0 element left in the sub-array
					int[] subList2 = Arrays.copyOfRange(subList, 3, subList.length);
					maxCheezeMouseCanHave(subList2, count + subList[1]);
				}
			}
		}
	}

}
/**
 * 2 6 8 5 10 100 10 5 3 1 2 3
 * 
 */