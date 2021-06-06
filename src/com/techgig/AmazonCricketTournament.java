package com.techgig;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;

public class AmazonCricketTournament {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < t; i++) {
			int result = getNoOfMatchesWithKnockout(arr[i]);
			System.out.println(result);
		}
	}

	private static int getNoOfMatchesWithKnockout(int n) {
		int cnt = 0;
		while (n>1) {
			cnt += n / 2;
			n = (n / 2) + (n % 2);
		}
		return cnt;
	}
}
/**
Input
2
4
7

*/