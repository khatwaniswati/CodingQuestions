package com.interviewbit.strings;

import java.util.Scanner;

public class StringBufferDemo {
	public static void main(String[] args) {
		// Don't alter anything here.
		Scanner inp = new Scanner(System.in);
		String S = inp.nextLine();
		int L = inp.nextInt();
		inp.nextLine();
		int R = inp.nextInt();
		inp.nextLine();
		inp.close();

		System.out.println(solve(S, L, R));
		/**************************************/
	}

	// complete the function below

	public static String solve(String s, int L, int R) {
		StringBuffer sb = new StringBuffer(s.substring(L - 1, R));
		return s.substring(0, L - 1) + sb.reverse().toString() + s.substring(R);
	}
}