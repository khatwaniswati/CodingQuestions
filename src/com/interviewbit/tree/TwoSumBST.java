package com.interviewbit.tree;

import java.util.Stack;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class TwoSumBST {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		System.out.println(t2Sum(root, 19));

		/*
		 * TreeNode root = new TreeNode(14); root.left = new TreeNode(1); root.right =
		 * new TreeNode(20); System.out.println(t2Sum(root, 21));
		 */

	}

	static boolean isPairPresent(TreeNode root, int target) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		boolean done1 = false, done2 = false;
		int val1 = 0, val2 = 0;
		TreeNode curr1 = root, curr2 = root;

		while (true) {

			while (done1 == false) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (s1.isEmpty())
						done1 = true;
					else {
						curr1 = s1.pop();
						val1 = curr1.val;
						curr1 = curr1.right;
						done1 = true;
					}
				}
			}

			while (done2 == false) {
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (s2.isEmpty())
						done2 = true;
					else {
						curr2 = s2.pop();
						val2 = curr2.val;
						curr2 = curr2.left;
						done2 = true;
					}
				}
			}

			// If we find a pair, then print the pair and return. The first
			// condition makes sure that two same values are not added
			if ((val1 != val2) && (val1 + val2) == target) {
				System.out.print("Pair Found: " + val1 + "+ " + val2 + " = " + target + "\n");
				return true;
			}

			// If sum of current values is smaller,
			// then move to next node in
			// normal inorder traversal
			else if ((val1 + val2) < target)
				done1 = false;

			// If sum of current values is greater,
			// then move to next node in
			// reverse inorder traversal
			else if ((val1 + val2) > target)
				done2 = false;

			// If any of the inorder traversals is
			// over, then there is no pair
			// so return false
			if (val1 >= val2)
				return false;
		}
	}

	public static int t2Sum(TreeNode A, int B) {
		/*
		 * int remaining = B - A.val; return findByTraversing(A, remaining);
		 */
		if (isPairPresent(A, B) == false)
			return 0;
		else
			return 1;
	}

	private static int findByTraversing(TreeNode root, int remaining) {
		if (root.val == remaining)
			return 1;

		if (remaining < root.val && root.left != null)
			return findByTraversing(root.left, remaining);
		else if (remaining > root.val && root.right != null)
			return findByTraversing(root.right, remaining);
		else
			return 0;
	}
}
