package com.interviewbit.tree;

class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(final int[] A) {
		int left = 0;
		int right = A.length;
		return recurseBST(A, left, right);
	}

	public static TreeNode recurseBST(int[] arr, int left, int right) {
		if (left >= right) {
			return null;
		}
		int middle = Math.round((right + left - 1) / 2);
		TreeNode node = new TreeNode(arr[middle]);
		if (left < middle) {
			node.left = recurseBST(arr, left, middle);
		}
		if (middle < right) {
			node.right = recurseBST(arr, middle + 1, right);
		}
		return node;
	}
	public static void main(String[] args) {
		/*
		 * int[] nums = {-10,-3,0,5,9}; TreeNode sortedArrayToBST =
		 * sortedArrayToBST(nums); System.out.println(sortedArrayToBST);
		 */
		int[] nums = {1,2,3};
		TreeNode sortedArrayToBST = sortedArrayToBST(nums);
		System.out.println(sortedArrayToBST);
	}
}