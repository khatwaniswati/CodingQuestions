package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class LessonsLearnt {

	public static void main(String[] args) {
		int t = -2147483648;
		long s = (long) t + (long) t;
		System.out.println(" " + s);

		int xt = -1 - Integer.MAX_VALUE - 1;
		System.out.println(">>" + Math.abs(xt));// lesson learnt
	}

	private static void test(ArrayList<ArrayList<Integer>> resultArrayList, ArrayList<Integer> arrayList) {
		System.out.println("r:" + resultArrayList);
		System.out.println("a:" + arrayList);
		arrayList = new ArrayList<>(Arrays.asList(-1, -1, 2));
		if (resultArrayList.contains(arrayList)) {
			System.out.println("yes");
		}

	}

	private static long abs(int i) {
		return Math.abs((long) i);
	}
}
