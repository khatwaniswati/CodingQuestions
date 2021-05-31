package com.interviewbit.strings;

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Wordl   "));
	}

	public static int lengthOfLastWord(final String A) {
		String result = A.trim();
		int count = 0;
		int n = result.length();

		if (!result.contains(" "))
			return result.length();

		for (int i = n - 1; i >= 0; i--) {
			int ch = result.charAt(i);
			if (ch == ' ') {
				return count;
			}
			count++;
		}
		return 0;
	}
}
