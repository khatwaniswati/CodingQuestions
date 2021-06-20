package com.interviewbit.math;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(12121 ));
		System.out.println(reverse(Integer.MIN_VALUE ));
		System.out.println(reverse(Integer.MAX_VALUE ));
	}

	public static int reverse(int A) {
		StringBuilder reverseSb = new StringBuilder(A + "");
		if (A < 0)
			reverseSb.deleteCharAt(0);

		int rev=0;
		try {
			rev = Integer.parseInt(reverseSb.reverse().toString());
		}catch (NumberFormatException e) {
			return 0;
		}

		if (A < 0)
			rev = rev * -1;

		return rev;
	}
}
