package com.hackerrank.morganstanley;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

class FountainActivation {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList( 2, 1, 1, 2, 1 );
		System.out.println(fountainActivation(asList));
	}

	public static int fountainActivation(List<Integer> locations) {
		int size=locations.size();
		int[] dp = new int[size];
		for (int i = 0; i < size; i++) {
			dp[i] = -1;
		}

		int left;
		int right;

		for (int i = 0; i < size; i++) {
			left = Math.max(i - locations.get(i), 0);
			right = Math.min(i + (locations.get(i) + 1), size);
			dp[left] = Math.max(dp[left], right);
		}
		//System.out.println(Arrays.toString(dp));

		int count = 1;

		int next = 0;
		right = dp[0];

		for (int i = 0; i < size; i++) {
			next = Math.max(next, dp[i]);
			if (i == right) {
				count++;
				right = next;
			}
		}
		return count;
	}

	public static int minTaps(int n, int[] ranges) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < ranges.length; i++) {
			int low = Math.max(0, i - ranges[i]);
			int high = i + ranges[i];
			map.put(low, Math.max(high, map.getOrDefault(low, 0)));
		}
		System.out.println(map);
		int[] jumps = new int[ranges.length];
		for (int i = 0; i < jumps.length; i++) {
			if (map.containsKey(i))
				jumps[i] = map.get(i) - i;
		}
		System.out.println(Arrays.toString(jumps));
		int low = 0;
		int high = 0;
		int layers = 0;
		while (high < ranges.length - 1) {
			int farthest = 0;
			for (int i = low; i <= high; i++)
				farthest = Math.max(farthest, i + jumps[i]);
			low = high + 1;
			high = farthest;
			if (low >= high)
				return -1;
			layers++;

		}
		return layers;
	}

	public int getResult(UnaryOperator<Integer> func) {
		return func.apply(1);
	}
}