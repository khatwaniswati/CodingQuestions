package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class InorderNonRecursive {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		//System.out.println(root);
		ArrayList<Integer> inorderTraversal = inorderTraversal(root);
		System.out.println(inorderTraversal);
	}

	public static ArrayList<Integer> inorderTraversal(TreeNode A) {
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
				result.add(trav.val);
				trav = trav.right;
			}
		}
		return result;
	}

	public void inorderNonrec(TreeNode A) {
		System.out.print("IN  : ");
		Stack<TreeNode> s = new Stack<>();
		TreeNode trav = A;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.isEmpty()) {
				trav = s.pop();
				System.out.print(trav.val + ", ");
				trav = trav.right;
			}
		}
		System.out.println();
	}
}
