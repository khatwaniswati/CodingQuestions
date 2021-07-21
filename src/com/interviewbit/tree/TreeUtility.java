package com.interviewbit.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		return "val=" + val + "| L:" + left + "|R:=" + right ;
	}

}

public class TreeUtility {

	static TreeNode root = null;

	public static TreeNode createBinarySearchTree(List<Integer> list) {
		for (Integer integer : list) {
			addNodeInBST(integer);
		}
		return root;
	}

	private static void addNodeInBST(int value) {
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
		} else if (value >= trav.val) {
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
		inorderTraversal(A.left, inorderTraversalA);
		inorderTraversalA.add(A.val);
		inorderTraversal(A.right, inorderTraversalA);
		return inorderTraversalA;
	}
	
	public static void inorderTraversal(TreeNode A) {
		if (A == null)
			return;
		inorderTraversal(A.left);
		System.out.println(A.val);
		inorderTraversal(A.right);
	}
	
	public static void bfsLevelwise() {
		System.out.print("BFS: ");
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.offer(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				TreeNode trav = q1.poll();
				System.out.print(trav.val + ", ");
				if (trav.left != null)
					q2.offer(trav.left);
				if (trav.right != null)
					q2.offer(trav.right);
			}
			System.out.print(" | ");
			while (!q2.isEmpty()) {
				TreeNode trav = q2.poll();
				System.out.print(trav.val + ", ");
				if (trav.left != null)
					q1.offer(trav.left);
				if (trav.right != null)
					q1.offer(trav.right);
			}
			System.out.print(" | ");
		}
		System.out.println();
	}
}
