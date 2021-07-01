package com.interviewbit.tree;

public class RemoveAllHAlfNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(11);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		System.out.println(root);
		root = removeAllHalfNodes(root);
		System.out.println(root);
	}

	private static TreeNode removeAllHalfNodes(TreeNode A) {
		if (A == null)
			return null;

		if (A.left == null && A.right == null)
			return A;

		A.left = removeAllHalfNodes(A.left);
		A.right = removeAllHalfNodes(A.right);
		if (A.left == null)
			return A.right;

		if (A.right == null)
			return A.left;

		return A;
	}

}
