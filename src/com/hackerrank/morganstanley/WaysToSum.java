package com.hackerrank.morganstanley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class WaysToSumResult {

	/*
	 * Complete the 'ways' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER total 2. INTEGER k
	 */
	int count = 0;

	public int findTargetSumWays(int[] nums, int S) {
		calculate(nums, 0, 0, S);
		return count;
	}

	public void calculate(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S)
				count++;
		} else {
			calculate(nums, i + 1, sum + nums[i], S);
			calculate(nums, i + 1, sum - nums[i], S);
		}
	}

	static int waysCopy(int total, int k) {
		total=total-1;
		k=k-1;
		int C[][] = new int[total + 1][k + 1];
		int i, j;
		for (i = 0; i <= total; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i)
					C[i][j] = 1;
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[total][k];
	}

	public static int ways(int total, int k) {
		int cnt = 0;
		List<List<Integer>> nested = new ArrayList<>();
		for (int i = 1; i <= k; i++) {
			List<Integer> lst = new ArrayList<>();
			int times = total / i;
			int remainder = total % i;
			System.out.println(times + "    " + remainder);
			while (times > 0) {
				lst.add(i);
				times--;
			}
			if (remainder > 0)
				lst.add(remainder);
			nested.add(lst);
			cnt++;
		}
		System.out.println(cnt + " " + nested);
		for (List<Integer> list : nested) {
			cnt += findMoreWays(list);
		}
		return cnt;
	}

	private static int findMoreWays(List<Integer> list) {
		return 0;
	}

}

public class WaysToSum {
	public static void main(String[] args) throws IOException {
		int k = 3;
		int total = 5;
		int result = WaysToSumResult.waysCopy(total, k);
		System.out.println(result);
	}
}
