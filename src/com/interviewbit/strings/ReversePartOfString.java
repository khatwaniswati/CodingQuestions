package com.interviewbit.strings;

import java.util.Scanner;

public class ReversePartOfString {
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

	public static String solve(String s, int L, int R) {
		StringBuffer sb = new StringBuffer(s);
		return sb.replace(L, R, new StringBuffer(s.substring(L, R)).reverse().toString()).toString();
	}
}