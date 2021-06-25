package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdenticalBinaryTrees {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(2, 1, 4, 5);
		List<Integer> lst2 = Arrays.asList(3, 6, 1, 2, 7);
		TreeNode createTreeA = TreeUtility.createBinarySearchTree(lst);
		TreeUtility.root = null;
		TreeNode createTreeB = TreeUtility.createBinarySearchTree(lst2);
		System.out.println(isSameTree(createTreeA, createTreeB));
		System.out.println(isSameTreeCopied(createTreeA, createTreeB));
	}

	public static int isSameTree(TreeNode A, TreeNode B) {
		List<Integer> inorderTraversalA = new ArrayList<>();
		inorderTraversal(A, inorderTraversalA);
		List<Integer> inorderTraversalB = new ArrayList<>();
		inorderTraversal(B, inorderTraversalB);
		System.out.println(inorderTraversalA);
		System.out.println(inorderTraversalB);
		if (inorderTraversalA.equals(inorderTraversalB))
			return 1;
		return 0;
	}

	private static List<Integer> inorderTraversal(TreeNode A, List<Integer> inorderTraversalA) {
		if (A == null)
			return inorderTraversalA;
		// print left subtree
		inorderTraversal(A.left, inorderTraversalA);
		// print root
		inorderTraversalA.add(A.val);
		inorderTraversal(A.right, inorderTraversalA);
		return inorderTraversalA;
	}

	public static int isSameTreeCopied(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return 1;
		if (A == null || B == null)
			return 0;

		if (A.val != B.val)
			return 0;

		return (isSameTree(A.left, B.left) & isSameTree(A.right, B.right));
	}

}
