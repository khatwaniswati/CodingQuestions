package com.interviewbit.tree;

public class BanalcedBinaryTree {
	public static void main(String[] args) {
		/*
		 * TreeNode createTree = new TreeNode(3); TreeNode left = new TreeNode(9);
		 * TreeNode right = new TreeNode(20); createTree.left = left; createTree.right =
		 * right;
		 * 
		 * TreeNode rightleft = new TreeNode(15); TreeNode rightright = new TreeNode(7);
		 * right.left = rightleft; right.right = rightright;
		 * 
		 * System.out.println(createTree); System.out.println(isBalanced(createTree));
		 */

		TreeNode createTree = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		createTree.left = left;
		createTree.right = right;

		TreeNode leftleft = new TreeNode(3);
		TreeNode leftright = new TreeNode(3);
		left.left = leftleft;
		left.right = leftright;

		TreeNode nextleft = new TreeNode(4);
		TreeNode nextright = new TreeNode(4);
		leftleft.left = nextleft;
		leftleft.right = nextright;

		System.out.println(createTree);
		System.out.println(isBalanced(createTree));
	}

	public static int height(TreeNode trav) {
		if (trav == null)
			return 0;
		int hl = height(trav.left);
		int hr = height(trav.right);
		return Math.max(hl, hr) + 1;
	}

	public static int isBalanced(TreeNode A) {
		if (A == null)
			return 1;

		int left = height(A.left);
		int right = height(A.right);
		// System.out.println("height(trav.left)::"+height(A.left));
		// System.out.println("height(trav.right)::"+height(A.right));
		if (Math.abs(left - right) <= 1 && isBalanced(A.left) == 1 && isBalanced(A.right) == 1) {
			return 1;
		} else {
			return 0;
		}
	}
}