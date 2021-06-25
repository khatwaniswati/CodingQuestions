package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class Merge2BinaryTrees {
	public static void main(String[] args) {
		/*
		 * List<Integer> lst = Arrays.asList(2, 1, 4, 5); List<Integer> lst2 =
		 * Arrays.asList(3, 6, 1, 2, 7);
		 */
		List<Integer> lst = Arrays.asList(12, 11, 14);
		List<Integer> lst2 = Arrays.asList(3, 6, 1);
		TreeNode createTreeA = TreeUtility.createBinarySearchTree(lst);
		TreeUtility.root = null;
		TreeNode createTreeB = TreeUtility.createBinarySearchTree(lst2);
		TreeNode merge = merge(createTreeA, createTreeB);
		List<Integer> inorderTraversalMerge = new ArrayList<>();
		System.out.println(TreeUtility.inorderTraversal(merge, inorderTraversalMerge));
	}

	public static TreeNode merge(TreeNode A, TreeNode B) {
		TreeNode root = null;
		if (A == null && B == null)
			return root;
		if (A == null)
			root = new TreeNode(B.val);
		else if (B == null)
			root = new TreeNode(A.val);
		else
			root = new TreeNode(A.val + B.val);
		if (root != null) {
			root.left = merge(A != null ? A.left : null, B != null ? B.left : null);
			root.right = merge(A != null ? A.right : null, B != null ? B.right : null);
		}
		return root;
	}

	public TreeNode copiedsolve(TreeNode first, TreeNode second) {
		if (first == null && second == null)
			return null;
		if (first == null && second != null)
			return second;
		if (first != null && second == null)
			return first;
		TreeNode node = new TreeNode(first.val + second.val);
		node.left = copiedsolve(first.left, second.left);
		node.right = copiedsolve(first.right, second.right);
		return node;
	}
}
