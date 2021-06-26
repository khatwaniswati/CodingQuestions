package com.hackerrank.morganstanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubSequence {

	/*
	 * Complete the function below.
	 */

	static int findLIS(int[] s) {
		int result = 0;
		for (int i = 0; i < s.length - 1; i++) {
			int maintain = s[i];
			int count = 0;
			for (int j = i + 1; j < s.length; j++) {
				if (s[j] > maintain) {
					count++;
					maintain = s[j];
				}
			}
			// System.out.println(count);
			if (count > 0 && result <= count)
				result = count + 1;
			// System.out.println(result);
		}
		return result;
	}

	public static int copied2DP(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				int j = Collections.binarySearch(sub, num);
				System.out.println(j + " " + sub + " " + num);
				if (j < 0)
					j = j * -1;
				j = j - 1;
				sub.set(j, num);
			}
		}

		return sub.size();
	}

	private int binarySearch(ArrayList<Integer> sub, int num) {
		int left = 0;
		int right = sub.size() - 1;
		int mid = (left + right) / 2;

		while (left < right) {
			mid = (left + right) / 2;
			if (sub.get(mid) == num) {
				return mid;
			}

			if (sub.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	static int copied(int[] s) {
		int[] dp = new int[s.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < s.length; i++) {
			for (int j = 0; j < i; j++) {
				if (s[i] > s[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int longest = 0;
		for (int c : dp) {
			longest = Math.max(longest, c);
		}

		return longest;
	}

	public static void main(String[] args) {
		int res;

		// int[] _s = {1,2,2,3,1,6};//4
		// int[] _s = {4,3,2,1};//4
		// int[] _s = {10,12,20,6,7,8,9,3,5};//4
//		int[] _s = {1,4,5,2,6};//4
		// int[] _s = {2,3,3,5};//3
		int[] _s = { 808, 7905, 9625, 7874, 8131, 8756, 12843, 11408, 9260, 15106, 11092, 16533, 16862, 17319, 19108,
				22263, 22614, 15376, 22711, 25360 };
		res = copied2DP(_s);
		System.out.println(res);

	}
}