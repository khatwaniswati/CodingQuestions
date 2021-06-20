package com.hackerrank.morganstanley;

// you can also use imports, for example:

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class StringABArrangement {
	public static void main(String[] args) {
		System.out.println(solution("BAAABAB"));
		System.out.println(solution("BBABAA"));
		System.out.println(solution("AABBBB"));
		System.out.println(solution("ABABABA"));
		System.out.println(solution("BAAABABBAA"));
	}
	public static int solution(String S) {
		//Map<Character, Long> map = S.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		//System.out.println(map);
		int AsAfterB=0,BsBeforeA=0;
		char[] charArray = S.toCharArray();
		int indexOfA = S.lastIndexOf('A');
		int indexOfB = S.indexOf('B');
		//System.out.println(indexOfA+" "+indexOfB);
		for (int j = 0; j <charArray.length ; j++) {
			if(charArray[j]=='B' && j<indexOfA)
				BsBeforeA++;
			if(charArray[j]=='A' && j>indexOfB)
				AsAfterB++;
		}
		//System.out.println(AsAfterB+" "+BsBeforeA);
		return AsAfterB<BsBeforeA?AsAfterB:BsBeforeA;
	}
}
