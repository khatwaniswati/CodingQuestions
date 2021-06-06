package com.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeGameTechgig {
	public static void main(String args[])  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n > 0) {
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			sc.close();
			for (int i = 0; i < n; i++) {
				System.out.println(findDiff(arr[i][0], arr[i][1]));
			}
		}
	}

	public static int findDiff(int a, int b) {
		List<Integer> lst = new ArrayList<>();
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				lst.add(i);
			}
		}

		int sz = lst.size();
		if (sz == 0)
			return -1;
		else if (sz == 1)
			return 0;
		else {
			int max = lst.stream().reduce(Integer::max).get();
			int min = lst.stream().reduce(Integer::min).get();
			return max - min;
		}
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		else if (n == 2)
			return true;
		else if (n % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
/**
Input
5
5 5
2 7
8 10
10 20
4 5
Output
0
5
-1
8
0
*/