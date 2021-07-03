package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class PreOrderNonRecursive {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		// System.out.println(root);
		ArrayList<Integer> inorderTraversal = preorderTraversal(root);
		System.out.println(inorderTraversal);
	}

	public static ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode trav = A;
		while (trav != null || !stack.isEmpty()) {
			while (trav != null) {
				result.add(trav.val);
				if (trav.right != null)
					stack.push(trav.right);
				trav = trav.left;
			}
			if (!stack.isEmpty()) {
				trav = stack.pop();
			}
		}
		return result;
	}
}
