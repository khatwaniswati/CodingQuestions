package com.interviewbit.strings;

// Java program to count special strings
class GfGVowelConsonant {

// Returns true if ch is vowel
	static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	}

// function to check consonant
	static boolean isCons(char ch) {
		return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
	}

	static int countSpecial(char[] str) {
		int len = str.length;

		// co[i] is going to store counts
		// of consonants from str[len-1]
		// to str[i].
		// vo[i] is going to store counts
		// of vowels from str[len-1]
		// to str[i].
		int co[] = new int[len + 1];
		int vo[] = new int[len + 1];

		// Counting consonants and vowels
		// from end of string.
		if (isCons(str[len - 1]) == true)
			co[len - 1] = 1;
		else
			vo[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			if (isCons(str[i]) == true) {
				co[i] = co[i + 1] + 1;
				vo[i] = vo[i + 1];
			} else {
				co[i] = co[i + 1];
				vo[i] = vo[i + 1] + 1;
			}
		}

		// Now we traverse string from beginning
		long ans = 0;
		for (int i = 0; i < len; i++) {
			// If vowel, then count of substrings
			// starting with str[i] is equal to
			// count of consonants after it.
			if (isVowel(str[i]))
				ans = ans + co[i + 1];

			// If consonant, then count of
			// substrings starting with str[i]
			// is equal to count of vowels
			// after it.
			else
				ans = ans + vo[i + 1];
		}

		return (int) ans;
	}

// Driver program
	public static void main(String[] args) {
		String str = "inttnikjmjbemrberk";
		System.out.println(countSpecial(str.toCharArray()));
	}
}

// This code contributed by Rajput-Ji
