package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderNonRecursive {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		// System.out.println(root);
		ArrayList<Integer> postOrderTraversal = postorderTraversalNonRecursive(root);
		System.out.println(postOrderTraversal);
		// postorderNonrec(root);
	}

	public static ArrayList<Integer> postorderTraversalNonRecursive(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode poppedS1 = s1.pop();
			s2.push(poppedS1);
			
			if(poppedS1.left != null)
				s1.push(poppedS1.left);
			if(poppedS1.right != null)
				s1.push(poppedS1.right);
		}
		while (!s2.isEmpty()) {
			list.add(s2.pop().val);
		}
		return list;
	}

	public static ArrayList<Integer> postorderTraversal(TreeNode trav) {
		ArrayList<Integer> list = new ArrayList<>();
		if (trav == null)
			return list;
		postorderTraversal(trav, list);
		return list;
	}

	public static void postorderTraversal(TreeNode trav, ArrayList<Integer> list) {
		if (trav == null)
			return;
		postorderTraversal(trav.left, list);
		postorderTraversal(trav.right, list);
		list.add(trav.val);
	}

	/*
	 * public static void postorderNonrec(TreeNode A) { System.out.print("POST: ");
	 * Stack<TreeNode> s = new Stack<>(); TreeNode trav = A; while (trav != null ||
	 * !s.isEmpty()) { while (trav != null) { s.push(trav); trav = trav.left; } if
	 * (!s.isEmpty()) { trav = s.pop(); if (trav.right == null ||
	 * trav.right.visited) { System.out.print(trav.val + ", "); trav.visited = true;
	 * trav = null; } else { s.push(trav); trav = trav.right; } } }
	 * System.out.println(); }
	 */
}