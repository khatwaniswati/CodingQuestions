package com.interviewbit.strings;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		List<String> lst = Arrays.asList("abcdefgh","aefghijk", "abcefgh");
		//List<String> lst = Arrays.asList("abab", "ab", "abcd");
		System.out.println(longestCommonPrefix(lst));
	}

	public static String longestCommonPrefix(List<String> A) {
		int minLen = A.stream().map(s->s.length()).reduce(Integer::min).get();
		boolean flag = false;
		int index=minLen;
		for (int j = 0; j < minLen; j++) {
			char first=A.get(0).charAt(j);
			for (int i = 1; i < A.size(); i++) {
				if(A.get(i).charAt(j)!=first) {
					flag=true;
					break;
				}
			}
			if(flag) {
				index=j;
				break;
			}
		}
		return A.get(0).substring(0,index);
	}
}
