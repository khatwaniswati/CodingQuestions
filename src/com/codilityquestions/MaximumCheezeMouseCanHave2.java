package com.codilityquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumCheezeMouseCanHave2 {

	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			result[i] = arr;
		}
		sc.close();
		for (int i = 0; i < t; i++) {
			maxSum = Integer.MIN_VALUE;
			maxCheezeMouseCanHave(result[i], 0);
			System.out.println(maxSum);
		}

		/*
		 * List<Integer> arr = new ArrayList<>(Arrays.asList(8, 5, 10, 100, 10, 5));
		 * maxCheezeMouseCanHave(arr, 0); System.out.println("Sum:" + maxSum);
		 * 
		 * List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3)); maxSum =
		 * Integer.MIN_VALUE; maxCheezeMouseCanHave(arr2, 0); System.out.println("Sum:"
		 * + maxSum);
		 * 
		 * List<Integer> arr3 = new ArrayList<>(Arrays.asList(9, 118, 202, 104, 10));
		 * maxSum = Integer.MIN_VALUE; maxCheezeMouseCanHave(arr3, 0);
		 * System.out.println("Sum:" + maxSum);
		 */
	}

	private static void maxCheezeMouseCanHave(int[] subList, int count) {
		if (subList.length == 0) {
			if (maxSum < count)
				maxSum = count;
		} else {
			if (subList.length == 2) {
				count += Math.max(subList[0], subList[1]);
				maxCheezeMouseCanHave(Collections.emptyList(), count);
			} else if (subList.length == 1) {
				count += subList[0];
				maxCheezeMouseCanHave(Collections.emptyList(), count);
			} else {
				if (subList.length > 2) {
					int[] subSubList = Arrays.copyOfRange(subList, 2, subList.length);
					maxCheezeMouseCanHave(subSubList, count + subList[0]);

					int[] subList2 = Arrays.copyOfRange(subList, 3, subList.length);
					maxCheezeMouseCanHave(subList2, count + subList[1]);
				}
			}
		}
	}

	private static void maxCheezeMouseCanHave(List<Integer> subList, int count) {
		if (subList.isEmpty()) {
			if (maxSum < count)
				maxSum = count;
		} else {
			if (subList.size() == 2) {
				count += Math.max(subList.get(0), subList.get(1));
				maxCheezeMouseCanHave(Collections.emptyList(), count);
			} else if (subList.size() == 1) {
				count += subList.get(0);
				maxCheezeMouseCanHave(Collections.emptyList(), count);
			} else {
				if (subList.size() > 2) {
					List<Integer> subSubList = subList.subList(2, subList.size());
					maxCheezeMouseCanHave(subSubList, count + subList.get(0));

					List<Integer> subList2 = subList.subList(3, subList.size());
					maxCheezeMouseCanHave(subList2, count + subList.get(1));
				}
			}
		}
	}

}
/**
2
6
8 5 10 100 10 5
3
1 2 3

*/