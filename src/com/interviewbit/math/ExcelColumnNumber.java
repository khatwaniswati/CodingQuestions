package com.interviewbit.math;

public class ExcelColumnNumber {
	public static void main(String[] args) {
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("CB"));
	}

	public static int titleToNumber(String A) {
		int result = 0;
		for (char c : A.toCharArray()) {
			System.out.println(c);
			result = result * 26 + (c - 'A') + 1;
			System.out.println(result);
		}
		return result;
	}
}
