package com.techgig;

import java.util.Scanner;

public class CoronaVirusSubsequenceTechgig {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		int n = sc.nextInt();
		if (n > 0) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
			sc.close();
			for (int i = 0; i < n; i++) {
				System.out.println(isSubSequence(arr[i], v));
			}
		}
	}

	public static String isSubSequence(String b, String v) {
		char[] bArr = b.toCharArray();
		char[] vArr = v.toCharArray();
		int bIndex = 0;
		int bLen = bArr.length;
		int vLen = vArr.length;
		for (int i = 0; i < vLen; i++) {
			if (bIndex < bLen && bArr[bIndex] == vArr[i]) {
				bIndex++;
			}
		}
		if (bIndex >= bArr.length) {
			return "POSITIVE";
		}
		return "NEGATIVE";
	}
}

/**
 * input
coronavirus 3 abcde crnas onarous
coronavirus 2 crna coronavirus
 */