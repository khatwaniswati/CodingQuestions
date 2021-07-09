package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutationFromLeetCode {
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private static void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	private static void reverse(ArrayList<Integer> list, int start) {
		int i = start, j = list.size() - 1;
		while (i < j) {
			swap(list, i, j);
			i++;
			j--;
		}
	}

	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
		int i = A.size() - 2;
		while (i >= 0 && A.get(i + 1) <= A.get(i)) {
			i--;
		}
		if (i >= 0) {
			int j = A.size() - 1;
			while (A.get(j) <= A.get(i)) {
				j--;
			}
			swap(A, i, j);
		}
		reverse(A, i + 1);
		return A;
	}

	public static void main(String[] args) {
		/*
		 * int[] arr = { 1, 4, 3, 2 }; nextPermutation(arr);
		 * System.out.println(Arrays.toString(arr));
		 */
		ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(20, 50, 113));
		System.out.println(nextPermutation(lst));
	}
}