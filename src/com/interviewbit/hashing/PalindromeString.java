package com.interviewbit.hashing;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromeString {
	public static void main(String[] args) {
		System.out.println(solve("abcde"));
		System.out.println(solve("abbaee"));
	}

	public static int solve(String A) {
		int len = A.length();
		Map<Character, Long> collect = A.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(collect);
		long oddCount = collect.values().stream().filter(v->v%2!=0).count();
		//System.out.println(oddCount);
		if(len%2==0 && oddCount==0)
			return 1;
		else if(len%2!=0 && oddCount==1)
			return 1;
		else 
			return 0;
	}
}
