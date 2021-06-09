package com.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelAndConsonantSubstring {
	public static void main(String[] args) {
		System.out.println(solve("inttnikjmjbemrberk"));
	}

	public static int solve(String A) {
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		List<String> sett = new ArrayList<>();
		for (int i = 2; i < A.length(); i++) {
			for (int j = 0; (j + i) <= A.length(); j++) {
				boolean isStartVowel = vowels.contains(A.charAt(j));
				boolean isEndCons = !vowels.contains(A.charAt(j + i - 1));
				boolean isStartCons = !vowels.contains(A.charAt(j));
				boolean isEndVowel = vowels.contains(A.charAt(j + i - 1));
				if ((isStartVowel && isEndCons) || (isStartCons && isEndVowel)) {
					sett.add(A.substring(j, j + i));
				}
			}
		}
		System.out.println(sett);
		return sett.size();
	}

}
