package com.backtracking;

import java.util.Arrays;

public class MaximalSwapString {

	public static void main(String[] args) {
		MaximalSwapString m = new MaximalSwapString();
		/*
		 * System.out.println(m.solve("254", 1)); System.out.println(m.solve("254", 2));
		 * System.out.println(m.solve("254", 5));
		 */
		System.out.println(m.solve("7599", 2));
	}

	/*
	 * public static String solve(String A, int B) { char[] charArray =
	 * A.toCharArray(); int swapCount = 0; String result = A; int first = 0; for
	 * (int i = 1; i < charArray.length ; i++) { if (charArray[first] <
	 * charArray[i]) { swapCount++; result = swap(result, first,i); first++; } if
	 * (swapCount == B || i == charArray.length -1) { return result; } } return
	 * result; }
	 * 
	 * private static String swap(String result, int i, int j) { StringBuilder sb =
	 * new StringBuilder(result); char charAtI = result.charAt(i); char charAtJ =
	 * result.charAt(j); sb.setCharAt(i, charAtJ); sb.setCharAt(j, charAtI); result
	 * = sb.toString(); System.out.println(":" + result); return result; }
	 */

	public String solve(String A, int B) {
		char[] arr = A.toCharArray();
		sol = A;
		gen(arr, 0, B);
		return sol;
	}

	String sol;

	public void gen(char[] arr, int ind, int B) {
		System.out.println(Arrays.toString(arr)+" "+ind+" "+B);
		if (ind >= arr.length)
			return;
		if (B == 0) {
			String str = String.valueOf(arr);
			if (str.compareTo(sol) > 0) {
				sol = str;
			}
			return;
		}

		for (int i = ind + 1; i < arr.length; i++) {
			if (arr[i] > arr[ind]) {
				swap(arr, ind, i);
				String str = String.valueOf(arr);
				if (str.compareTo(sol) > 0) {
					sol = str;
				}
				System.out.println(sol);
				gen(arr, ind + 1, B - 1);
				swap(arr, ind, i);
			}
		}
		gen(arr, ind + 1, B);
	}

	public void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * Solution Approach 1) Create a global variable which will store the maximum
	 * string or number. 2) Define a recursive function that takes the string as
	 * number and value of k 3) Run a nested loop, the outer loop from 0 to length
	 * of string -1 and inner loop from i+1 to end of string. 4) Swap the ith and
	 * jth character and check if the string is now maximum and update the maximum
	 * string. 5) Call the function recursively with parameters: string and k-1. 6)
	 * Now again swap back the ith and jth character.
	 */
}
