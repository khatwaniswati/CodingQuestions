package com.interviewbit.math;

public class ExcelColumnTitle {

	public static String convertToTitle(int A) {
		StringBuilder result = new StringBuilder();
		if(A<=26) {
			char b = (char) (A + 'A' - 1);
			return b+"";
		}
		while (A > 0) {
			int mod = A % 26;
			if(mod==0) {
				result.append('Z');
				A=(A/26)-1;
			}else {
				char b = (char) (mod + 'A' - 1);
				result.append(b);
				A = A / 26;
			}
		}
		
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(convertToTitle(705));
		 * System.out.println(convertToTitle(51));
		 * System.out.println(convertToTitle(26));
		 */
		System.out.println(convertToTitle(80));
		System.out.println(convertToTitle(676));
		System.out.println(convertToTitle(702));
		System.out.println(convertToTitle(52));
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
