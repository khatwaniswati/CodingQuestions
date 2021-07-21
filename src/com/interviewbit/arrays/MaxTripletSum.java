package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.TreeSet;

public class MaxTripletSum {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 1, 4, 9 };
		System.out.println(maxTripletSum(arr, arr.length));
	}

	public static int maxTripletSum(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] < arr[j] && arr[j] < arr[k]) {
						int tempSum = arr[i] + arr[j] + arr[k];
						if (tempSum > sum)
							sum = tempSum;
					}
				}
			}
		}
		return sum;
	}

	public static int solve(ArrayList<Integer> A) {
		int n = A.size();
		// Initialize suffix-array
		int maxSuffArr[] = new int[n + 1];

		// Set the last element
		maxSuffArr[n] = 0;

		// Calculate suffix-array containing maximum
		// value for index i, i+1, i+2, ... n-1 in
		// arr[i]
		for (int i = n - 1; i >= 0; --i)
			maxSuffArr[i] = Math.max(maxSuffArr[i + 1], A.get(i));

		int ans = 0;

		// Initialize set container
		TreeSet<Integer> lowValue = new TreeSet<Integer>();

		// Insert minimum value for first comparison
		// in the set
		lowValue.add(Integer.MIN_VALUE);

		for (int i = 0; i < n - 1; ++i) {
			if (maxSuffArr[i + 1] > A.get(i)) {
				ans = Math.max(ans, lowValue.lower(A.get(i)) + A.get(i) + maxSuffArr[i + 1]);

				// Insert arr[i] in set<> for further
				// processing
				lowValue.add(A.get(i));
			}
		}
		return ans;
	}
}
