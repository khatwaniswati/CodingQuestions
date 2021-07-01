package com.interviewbit.tree;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

class CousinsInBinaryTree {
	public static void main(String[] args) {
		/*
		 * TreeNode createTree = new TreeNode(1); TreeNode left = new TreeNode(2);
		 * TreeNode right = new TreeNode(3); createTree.left = left; createTree.right =
		 * right;
		 * 
		 * TreeNode leftright = new TreeNode(4); left.right = leftright;
		 * 
		 * TreeNode rightleft = new TreeNode(5); right.left = rightleft; //
		 * System.out.println(createTree); // System.out.println(isCousins(createTree,
		 * 4, 5)); System.out.println(solve(createTree, 5));
		 */
		/*
		 * TreeNode createTree = new TreeNode(1); TreeNode left = new TreeNode(2);
		 * TreeNode right = new TreeNode(3); createTree.left = left; createTree.right =
		 * right;
		 * 
		 * TreeNode leftleft = new TreeNode(4); TreeNode leftright = new TreeNode(5);
		 * left.left = leftleft; left.right = leftright;
		 * 
		 * TreeNode rightleft = new TreeNode(6); TreeNode rightright = new TreeNode(7);
		 * right.left = rightleft; right.right = rightright;
		 * System.out.println(solve(createTree, 5));
		 */
		/*
		 * TreeNode createTree = new TreeNode(9); TreeNode left = new TreeNode(1);
		 * TreeNode right = new TreeNode(2); createTree.left = left; createTree.right =
		 * right;
		 * 
		 * TreeNode leftleft = new TreeNode(3); TreeNode leftright = new TreeNode(-1);
		 * left.left = leftleft; left.right = leftright;
		 * 
		 * TreeNode rightleft = new TreeNode(-1); TreeNode rightright = new TreeNode(4);
		 * right.left = rightleft; right.right = rightright;
		 * System.out.println(solve(createTree, 2));
		 */
		
		//63 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 
		//12
		TreeNode createTree = new TreeNode(63);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		createTree.left = left;
		createTree.right = right;

		TreeNode leftleft = new TreeNode(3);
		TreeNode leftright = new TreeNode(4);
		left.left = leftleft;
		left.right = leftright;

		TreeNode rightleft = new TreeNode(5);
		TreeNode rightright = new TreeNode(6);
		right.left = rightleft;
		right.right = rightright;
		
		TreeNode leftleftleft = new TreeNode(7);
		TreeNode leftrightright = new TreeNode(8);
		leftleft.left = leftleftleft;
		leftleft.right = leftrightright;

		TreeNode rightleftleft = new TreeNode(9);
		TreeNode rightrightright = new TreeNode(10);
		leftright.left = rightleftleft;
		leftright.right = rightrightright;
		
		System.out.println(printCousins(createTree, 7));
	}

	static ArrayList<Integer> printCousins(TreeNode A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A.val == B) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean found = false;
		int size_ = 0;
		TreeNode p = null;
		q.add(A);

		while (q.isEmpty() == false && found == false) {

			size_ = q.size();
			while (size_-- > 0) {
				p = q.peek();
				q.remove();
				if ((p.left !=null && p.left.val == B) || (p.right !=null && p.right.val == B)) {
					found = true;
				} else {
					if (p.left != null)
						q.add(p.left);
					if (p.right != null)
						q.add(p.right);
				}

			}
			
		}

		if (found == true) {
			size_ = q.size();
			if (size_ == 0)
				return result;

			for (int i = 0; i < size_; i++) {
				p = q.peek();
				q.poll();

				result.add(p.val);
			}
		}
		return result;
	}
	
	public static boolean isCousins(TreeNode root, int x, int y) {
		int[] parents = new int[2];
		int[] depths = new int[2];
		helper(root, x, y, 0, 0, parents, depths);
		return depths[0] == depths[1] && parents[0] != parents[1];
	}

	private static Entry<TreeNode, Integer> getParentsSiblingAndDepth(TreeNode root, int x, TreeNode grandParent,
			int depth) {
		Entry<TreeNode, Integer> entry = null;
		if (root == null)
			return entry;
		if ((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
			if (grandParent!= null && grandParent.left == root)
				entry = new AbstractMap.SimpleEntry(grandParent.right, depth);
			else if (grandParent!= null && grandParent.right == root)
				entry = new AbstractMap.SimpleEntry(grandParent.left, depth);
			return entry;
		}
		if (getParentsSiblingAndDepth(root.left, x, root, depth + 1) != null)
			return getParentsSiblingAndDepth(root.left, x, root, depth + 1);
		if (getParentsSiblingAndDepth(root.right, x, root, depth + 1) != null)
			return getParentsSiblingAndDepth(root.right, x, root, depth + 1);
		return entry;
	}

	private static void helper(TreeNode root, int x, int y, int parent, int depth, int[] parents, int[] depths) {
		System.out.println(root);
		if (root == null)
			return;
		if (root.val == x) {
			parents[0] = parent;
			depths[0] = depth;
		} else if (root.val == y) {
			parents[1] = parent;
			depths[1] = depth;
		}
		helper(root.left, x, y, root.val, depth + 1, parents, depths);
		helper(root.right, x, y, root.val, depth + 1, parents, depths);
	}

	public static ArrayList<Integer> solve(TreeNode A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		Entry<TreeNode, Integer> parentsSiblingAndDepth = getParentsSiblingAndDepth(A, B, null, 0);
		/*
		 * System.out.println("ParentsSibling:");
		 * System.out.println(parentsSiblingAndDepth);
		 */
		if(parentsSiblingAndDepth!=null) {
			TreeNode key = parentsSiblingAndDepth.getKey();
			if (key != null && key.left != null)
				result.add(key.left.val);
			if (key != null && key.right != null)
				result.add(key.right.val);
		}
		return result;

	}

	public boolean traverseInLevelOrder(List<TreeNode> candidates, int x, int y) {
		if (candidates.size() == 0)
			return false;

		int xId = -1;
		int yId = -1;
		List<TreeNode> nextLevel = new LinkedList<TreeNode>();
		for (int i = 0; i < candidates.size(); ++i) {
			TreeNode myNode = candidates.get(i);
			if (myNode.left != null) {
				nextLevel.add(myNode.left);
				if (myNode.left.val == x)
					xId = i;
				if (myNode.left.val == y)
					yId = i;
			}
			if (myNode.right != null) {
				nextLevel.add(myNode.right);
				if (myNode.right.val == x)
					xId = i;
				if (myNode.right.val == y)
					yId = i;
			}
		}

		return (xId != yId && xId != -1 && yId != -1) || traverseInLevelOrder(nextLevel, x, y);
	}
}