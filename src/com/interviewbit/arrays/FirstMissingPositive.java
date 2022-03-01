package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(1, 2, 0))));
		System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(3, 4, -1, 1))));
		System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(7, 8, 9, 11, 12))));
	}

	public static int firstMissingPositiveCopied(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			int num = A.get(i);
			int pos = num - 1;

			if (pos >= 0 && pos < A.size() && A.get(pos) != num) {
				A.set(i, A.get(pos));
				A.set(pos, num);
				i--;
			}
		}

		for (int i = 0; i < A.size(); i++)
			if (A.get(i) != i + 1)
				return i + 1;

		return A.size() + 1;
	}

	public static int firstMissingPositive(ArrayList<Integer> A) {
		Collections.sort(A);
		int missing = 1;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == missing) {
				missing++;
			}
		}
		return missing;
	}
}
