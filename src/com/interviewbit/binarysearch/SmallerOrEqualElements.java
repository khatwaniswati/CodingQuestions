package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallerOrEqualElements {
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<>(Arrays.asList(1, 3, 4, 4, 6)), 4));
		System.out.println(solve(new ArrayList<>(Arrays.asList(1, 2, 5, 5)), 3));
	}

	public static int solve(ArrayList<Integer> A, int B) {
		/*
		 * int low = 0, high = A.size() - 1; while (low < high) { int mid = (low + high)
		 * / 2; if(A.get(mid)<B) }
		 */
		return (int)A.stream().filter(i->i<=B).count();
	}
}
