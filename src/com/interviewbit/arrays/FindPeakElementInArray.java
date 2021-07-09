package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElementInArray {

	public static void main(String[] args) {
		/*
		 * int[] arr = { 5, 10, 20, 15 }; System.out.println(findPeak(arr, 4));
		 * System.out.println(perfectPeak(new ArrayList(Arrays.asList(5, 10, 20, 15))));
		 * 
		 * int[] arr1 = { 10, 20, 15, 2, 23, 90, 67 }; System.out.println(findPeak(arr1,
		 * 7)); System.out.println(perfectPeak(new ArrayList(Arrays.asList(10, 20, 15,
		 * 2, 23, 90, 67))));
		 * 
		 * int[] arr2 = { 10, 20, 30, 40, 50 }; System.out.println(findPeak(arr2, 5));
		 * System.out.println(perfectPeak(new ArrayList(Arrays.asList(10, 20, 30, 40,
		 * 50))));
		 * 
		 * int[] arr3 = { 50, 40, 30, 20, 10 }; System.out.println(findPeak(arr3, 5));
		 * System.out.println(perfectPeak(new ArrayList(Arrays.asList(50, 40, 30, 20,
		 * 10))));
		 * 
		 * int[] arr4 = { 3, 3, 3 }; System.out.println(findPeak(arr4, 3));
		 * System.out.println(perfectPeak(new ArrayList(Arrays.asList(3, 3, 3))));
		 * 
		 * int[] arr5 = { 3, 2, 3, 11 }; System.out.println(findPeak(arr5, 4));
		 * System.out.println(perfectPeak(new ArrayList(Arrays.asList(3, 2, 3, 11 ))));
		 */

		System.out.println(perfectPeakCopy(new ArrayList(Arrays.asList(5706, 26963, 24465, 29359, 16828, 26501, 28146,
				18468, 9962, 2996, 492, 11479, 23282, 19170, 15725, 6335))));
	}

	public static int findPeak(int arr[], int n) {
		int l = 0;
		int h = n;

		while (l < h) {
			int mid = (l + h) / 2;
			if (mid + 1 < n && mid - 1 >= 0 && arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1])
				return arr[mid];
			else {
				if (mid + 1 < n && arr[mid] < arr[mid + 1]) {
					l = mid + 1;
				} else if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
					h = mid - 1;
				} else {
					return arr[mid];
				}
			}
		}
		return -1;
	}

	public static int perfectPeak(ArrayList<Integer> A) {
		int n = A.size();
		int l = 0;
		int h = A.size();

		while (l < h) {
			int mid = (l + h) / 2;
			if (mid + 1 < n && mid - 1 >= 0 && A.get(mid) >= A.get(mid + 1) && A.get(mid) >= A.get(mid - 1))
				return 1;
			else {
				if (mid + 1 < n && A.get(mid) < A.get(mid + 1)) {
					l = mid + 1;
				} else if (mid - 1 >= 0 && A.get(mid) < A.get(mid - 1)) {
					h = mid - 1;
				} else {
					break;
				}
			}
		}
		return 0;
	}

	public static int perfectPeakCopy(ArrayList<Integer> A) {
		int n = A.size();
		int[] leftMax = new int[n];
		int[] rightMin = new int[n];
		leftMax[0] = A.get(0);
		rightMin[n - 1] = A.get(n - 1);
		for (int i = 1; i < n; i++)
			leftMax[i] = Math.max(leftMax[i - 1], A.get(i));
		for (int i = n - 2; i >= 0; i--)
			rightMin[i] = Math.min(rightMin[i + 1], A.get(i));

		for (int i = 1; i < n - 1; i++) {
			if (A.get(i) > leftMax[i - 1] && A.get(i) < rightMin[i + 1])
				return 1;
		}

		return 0;
	}
}
