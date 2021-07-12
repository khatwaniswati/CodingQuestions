package com.interviewbit;

public class StringBufferProblem {
	public static void main(String[] args) {
		String S = "Test";
		int L = 1;
		int R = 3;
		System.out.println(solve(S, L, R));
	}

	// complete the function below

	public static String solve(String s, int L, int R) {
		StringBuffer sb = new StringBuffer(s);
		return sb.replace(L, R + 1, new StringBuffer(s.substring(L, R + 1)).reverse().toString()).toString();
	}
}