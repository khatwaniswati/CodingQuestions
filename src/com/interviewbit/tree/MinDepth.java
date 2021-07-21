package com.interviewbit.tree;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class MinDepth {

	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		createTree.left = left;
		createTree.right = right;
		TreeNode nextleft = new TreeNode(4);
		right.left = nextleft;

		TreeNode nextLeftRight = new TreeNode(5);
		nextleft.right = nextLeftRight;

		System.out.println(createTree);
		System.out.println(minDepth(createTree));
	}

	public static int minHeight(TreeNode A, int level) {
		if (A == null)
			return level;
		level++;

		if (A.left == null)
			return minHeight(A.right, level);
		if (A.right == null)
			return minHeight(A.left, level);

		return Math.min(minHeight(A.left, level), minHeight(A.right, level));
	}

	public static int minDepth(TreeNode A) {
		return minHeight(A, 0);
	}

}
