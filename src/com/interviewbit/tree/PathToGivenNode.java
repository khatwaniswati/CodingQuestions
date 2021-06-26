package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PathToGivenNode {
	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		createTree.left = left;
		createTree.right = right;

		TreeNode leftleft = new TreeNode(4);
		TreeNode leftright = new TreeNode(5);
		left.left = leftleft;
		left.right = leftright;

		TreeNode rightleft = new TreeNode(6);
		TreeNode rightright = new TreeNode(7);
		right.left = rightleft;
		right.right = rightright;

		int[] solve = solve(createTree, 1);
		System.out.println(Arrays.toString(solve));
	}
	public static boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x) {
		if (root == null)
			return false;
		
		arr.add(root.val);

		if (root.val == x)
			return true;
		
		if(hasPath(root.left, arr, x) || hasPath(root.right, arr, x) )
			return true;
		
		arr.remove(arr.size()-1);
		return false;
	}
	public static int[] solve(TreeNode A, int B) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if(hasPath(A,arrayList , B)) {
			int[] arr = new int[arrayList.size()];
			for (int i = 0; i < arrayList.size(); i++) {
				arr[i]=arrayList.get(i);
			}
			return arr;
		}
		return new int[1];
	}
}
