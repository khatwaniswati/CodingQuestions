package com.hackerrank.morganstanley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ResultNNNO {

	/*
	 * Complete the 'countOptions' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER people 2. INTEGER groups
	 */

	public static long countOptions(int people, int groups) {
		//7->3 111
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> lst = new ArrayList<>();
		int max=people-groups-1;
		System.out.println(max);
		for (int j = 0; j < max; j++) {
			lst.add(1);
		}
		lst.add(people-max);
		result.add(lst);
		System.out.println(result);
		
		
		return 0;
	}

	public static int nToKGroups(int n, int k) {
		if (n < k) {
			return 0;
		}
		int[][] dp = new int[k + 1][n + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= n; j++) {
				if (i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - i];
				}
			}
		}
		return dp[k][n];
	}

}

public class GroupingOptionsSolution {
	public static void main(String[] args) throws IOException {
//		long result = Result.nToKGroups(8, 4);
		long result = ResultNNNO.countOptions(7, 3);
		System.out.println(result);
	}
}
