package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricBinaryTree {
	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(5);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		createTree.left = left;
		createTree.right = right;

		TreeNode leftleft = new TreeNode(-1);
		TreeNode leftright = new TreeNode(-1);
		left.left = leftleft;
		left.right = leftright;

		TreeNode rightleft = new TreeNode(-1);
		TreeNode rightright = new TreeNode(3);
		right.left = rightleft;
		// right.right = rightright;

		/*
		 * TreeNode createTree = new TreeNode(1); TreeNode left = new TreeNode(2);
		 * TreeNode right = new TreeNode(2); createTree.left = left; createTree.right =
		 * right;
		 */

		/*
		 * TreeNode leftleft = new TreeNode(3); TreeNode leftright = new TreeNode(4);
		 * left.left = leftleft; left.right = leftright;
		 * 
		 * TreeNode rightleft = new TreeNode(4); TreeNode rightright = new TreeNode(3);
		 * right.left = rightleft; right.right = rightright;
		 */

		/*
		 * TreeNode leftleft = new TreeNode(3); TreeNode leftright = new TreeNode(4);
		 * left.right = leftright;
		 * 
		 * TreeNode rightleft = new TreeNode(4); TreeNode rightright = new TreeNode(3);
		 * right.right = rightright;
		 */

		// TreeNode createTree = TreeUtility.createTree(Arrays.asList(1, 2, 3, 4,5,6));
		System.out.println(isSymmetric(createTree));
		System.out.println(isSymmetricCopiedIterative(createTree));
	}

	public static void bfs(TreeNode root) {
		System.out.print("BFS: ");
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode trav = q.poll();
			System.out.print(trav.val + ", ");
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);
		}
		System.out.println();
	}

	public static int bfsLevelwise(TreeNode root) {
		System.out.print("BFS: ");
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.offer(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> result = new ArrayList<>();
			while (!q1.isEmpty()) {
				TreeNode trav = q1.poll();
				System.out.print(trav.val + ", ");
				if (trav.val != -1)
					result.add(trav.val);
				if (trav.left != null)
					q2.offer(trav.left);
				if (trav.right != null)
					q2.offer(trav.right);
			}
			System.out.println(result);
			if (!isSymmetricList(result))
				return 0;
			System.out.print(" | ");
			result = new ArrayList<>();
			while (!q2.isEmpty()) {
				TreeNode trav = q2.poll();
				System.out.print(trav.val + ", ");
				if (trav.val != -1)
					result.add(trav.val);
				if (trav.left != null)
					q1.offer(trav.left);
				if (trav.right != null)
					q1.offer(trav.right);
			}
			System.out.println(result);
			if (!isSymmetricList(result))
				return 0;
			System.out.print(" | ");
		}
		System.out.println();
		return 1;
	}

	private static boolean isSymmetricList(List<Integer> result) {
		List<Integer> lst = new ArrayList<>(result);
		Collections.reverse(lst);
		return lst.equals(result);
	}

	public static int isSymmetricCopiedIterative(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		q.add(A);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return 0;
			if (t1.val != t2.val)
				return 0;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return 1;
	}
	
	public boolean isSymmetricCopiedRecursive(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}

	public static int isSymmetric(TreeNode A) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.offer(A);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> result = new ArrayList<>();
			while (!q1.isEmpty()) {
				TreeNode trav = q1.poll();
				if (trav.val != -1)
					result.add(trav.val);
				if (trav.left != null)
					q2.offer(trav.left);
				if (trav.right != null)
					q2.offer(trav.right);
			}
			if (!isSymmetricList(result))
				return 0;
			result = new ArrayList<>();
			while (!q2.isEmpty()) {
				TreeNode trav = q2.poll();
				if (trav.val != -1)
					result.add(trav.val);
				if (trav.left != null)
					q1.offer(trav.left);
				if (trav.right != null)
					q1.offer(trav.right);
			}
			if (!isSymmetricList(result))
				return 0;
		}
		return 1;
	}
}
