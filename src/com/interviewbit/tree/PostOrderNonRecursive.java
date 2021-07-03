package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderNonRecursive {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		// System.out.println(root);
		ArrayList<Integer> inorderTraversal = postOrderTraversal(root);
		System.out.println(inorderTraversal);
	}

	public static ArrayList<Integer> postOrderTraversal(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode trav = A;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.isEmpty()) {
				trav = s.pop();
				if (trav.right != null) {
					trav = trav.right;
					result.add(trav.val);
				}
			}
		}
		return result;
	}
}