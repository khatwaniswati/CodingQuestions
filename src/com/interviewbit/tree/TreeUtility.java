package com.interviewbit.tree;

import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

}

public class TreeUtility {

	static TreeNode root = null;

	public static TreeNode createTree(List<Integer> list) {
		for (Integer integer : list) {
			addNode(integer);
		}
		return root;
	}

	private static void addNode(int value) {
		if (isEmpty())
			root = new TreeNode(value);
		else
			addNode(root, value);
	}

	private static void addNode(TreeNode trav, int value) {
		TreeNode newNode = new TreeNode(value);
		if (value < trav.val) {
			if (trav.left == null) {
				trav.left = newNode;
				return;
			}
			addNode(trav.left, value);
		} else if (value > trav.val) {
			if (trav.right == null) {
				trav.right = newNode;
				return;
			}
			addNode(trav.right, value);
		}
	}

	private static boolean isEmpty() {
		return root == null;
	}

	public static List<Integer> inorderTraversal(TreeNode A, List<Integer> inorderTraversalA) {
		if (A == null)
			return inorderTraversalA;
		// print left subtree
		inorderTraversal(A.left, inorderTraversalA);
		// print root
		inorderTraversalA.add(A.val);
		inorderTraversal(A.right, inorderTraversalA);
		return inorderTraversalA;
	}
}
