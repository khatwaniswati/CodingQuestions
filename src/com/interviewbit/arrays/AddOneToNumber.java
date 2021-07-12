package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class AddOneToNumber {

	/*
	 * public static void main(String[] args) { // int[] arr = { 1, 7, 8, 9 }; //
	 * int[] arr = { 4,3,2,1 }; int[] arr = { 0 }; // int[] arr = {9,9,9}; int[]
	 * plusOne = plusOne(arr); System.out.println(Arrays.toString(plusOne)); }
	 */
	public static void main(String[] args) {
		// int[] arr = { 1, 7, 8, 9 };
		// int[] arr = { 4,3,2,1 };
		//ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9));
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(0, 0, 4, 4, 6, 0, 9, 6, 5, 1));
		//ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5));
		// int[] arr = {9,9,9};
		ArrayList<Integer> plusOne = plusOne(arrList);
		System.out.println(plusOne);
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> plusOne = new ArrayList<>();
		int carry = 0;
		boolean flag = true;
		for (int i = A.size() - 1; i >= 0; i--) {
			if (flag) {
				int plusOneTemp = A.get(i) + 1;
				flag = false;
				if (plusOneTemp > 9) {
					carry = 1;
					plusOne.add(0);
				} else {
					plusOne.add(plusOneTemp);
				}
				continue;
			}
			int plus = A.get(i) + carry;
			if (plus > 9) {
				plusOne.add(0);
				carry = 1;
			} else {
				carry = 0;
				plusOne.add(plus);
			}
		}
		if (carry > 0) {
			plusOne.add(carry);
		}
		Collections.reverse(plusOne);

		if (plusOne.get(0) == 0) {
			int firstNonZeroDigitIndex = 0;
			for (int i = 1; i < plusOne.size() ; i++) {
				if(plusOne.get(i)>0) {
					firstNonZeroDigitIndex=i;
					break;
				}
			}
			
			List<Integer> subList = plusOne.subList(firstNonZeroDigitIndex, plusOne.size());
			plusOne = new ArrayList<>(subList);
		}
		return plusOne;
	}

	public static int[] plusOne(int[] digits) {
		int[] plusOne = new int[digits.length];
		int carry = 0;
		boolean flag = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (flag) {
				digits[i] += 1;
				flag = false;
				if (digits[i] > 9) {
					carry = 1;
					plusOne[i] = 0;
				}
			}
			int plus = digits[i] + carry;
			if (plus > 9) {
				plusOne[i] = 0;
				carry = 1;
			} else {
				carry = 0;
				plusOne[i] = plus;
			}
		}
		if (carry > 0) {
			int[] dupliate = plusOne;
			plusOne = new int[digits.length + 1];
			plusOne[0] = carry;
			for (int i = 0; i < dupliate.length; i++) {
				plusOne[i + 1] = dupliate[i];
			}
		}
		return plusOne;
	}

}