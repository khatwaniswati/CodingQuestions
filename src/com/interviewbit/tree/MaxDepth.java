package com.interviewbit.tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MaxDepth {

	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		createTree.left = left;
		createTree.right = right;

		/*
		 * TreeNode leftleft = new TreeNode(n); TreeNode leftright = new TreeNode(3);
		 * left.left = leftleft; left.right = leftright;
		 */

		TreeNode nextleft = new TreeNode(15);
		TreeNode nextright = new TreeNode(7);
		right.left = nextleft;
		right.right = nextright;

		System.out.println(createTree);
		System.out.println(maxDepth(createTree));
	}

	public static int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}

}