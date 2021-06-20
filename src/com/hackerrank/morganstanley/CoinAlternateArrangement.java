package com.hackerrank.morganstanley;
// you can also use imports, for example:

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CoinAlternateArrangement {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 0, 1, 1 };
		System.out.println(solution(arr));

		int[] arr2 = { 1, 1, 0, 1, 1 };
		System.out.println(solution(arr2));

		int[] arr3 = { 0, 1, 0 };
		System.out.println(solution(arr3));

		int[] arr4 = { 0, 1, 1, 0 };
		System.out.println(solution(arr4));
		
		int[] arr5 = {1, 0, 1, 1, 0 };
		System.out.println(solution(arr5));
	}

	public static int solution(int[] A) {
		int result = 0;
		int lastSecondXOR=0,lastXOR = 0;
		for (int i = 0; i < A.length-1; i++) {
			if(i==A.length-3)
				lastSecondXOR=A[i]^A[i+1];
			if(i==A.length-2)
				lastXOR=A[i]^A[i+1];
			if((A[i]^A[i+1])==0)
				result++;
		}
		if(lastSecondXOR==0 && lastXOR==1) {
			System.out.println("Yess");
			result++;
		}
		return result;
	}
}
