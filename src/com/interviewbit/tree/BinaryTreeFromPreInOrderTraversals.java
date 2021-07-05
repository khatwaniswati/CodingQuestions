package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

class BinaryTreeFromPreInOrderTraversals {
	public static void main(String[] args) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(2, 1, 6, 5, 3, 4));
		ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(5, 6, 1, 2, 3, 4));
		System.out.println(buildTree(preOrder, inOrder));
	}

	public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
		TreeNode root = new TreeNode(preorder.get(0));

		if (inorder.size() > 1) {
			ArrayList<Integer> inOrderleftSubTree = new ArrayList<Integer>(
					inorder.subList(0, inorder.indexOf(preorder.get(0))));
			ArrayList<Integer> inOrderRightSubTree = new ArrayList<Integer>(
					inorder.subList(inorder.indexOf(preorder.get(0)) + 1, inorder.size()));

			if (inOrderleftSubTree.size() == 1) {
				root.left = new TreeNode(inOrderleftSubTree.get(0));
			} else if (inOrderleftSubTree.size() != 0) {
				ArrayList<Integer> preOrderLeftSubTree = new ArrayList<Integer>(
						preorder.subList(1, preorder.size() - inOrderRightSubTree.size()));
				root.left = buildTree(preOrderLeftSubTree, inOrderleftSubTree);
			}

			if (inOrderRightSubTree.size() == 1) {
				root.right = new TreeNode(inOrderRightSubTree.get(0));
			} else if (inOrderRightSubTree.size() != 0) {
				ArrayList<Integer> preOrderRightSubTree = new ArrayList<Integer>(
						preorder.subList(preorder.size() - inOrderRightSubTree.size(), preorder.size()));
				root.right = buildTree(preOrderRightSubTree, inOrderRightSubTree);
			}
		}

		return root;
	}

	static int pIndex = 0;

	public TreeNode buildTreeWithoutRecursion(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

		int len = inorder.size();
		pIndex = 0;
		return createTree(0, len - 1, inorder, preorder);
	}

	public TreeNode createTree(int start, int end, ArrayList<Integer> inorder, ArrayList<Integer> preorder) {

		if (start > end)
			return null;

		TreeNode node = new TreeNode(preorder.get(pIndex++));
		if (start == end)
			return node;

		int inIndex = search(node.val, inorder, start, end);

		node.left = createTree(start, inIndex - 1, inorder, preorder);
		node.right = createTree(inIndex + 1, end, inorder, preorder);

		return node;
	}

	public int search(int num, ArrayList<Integer> inorder, int start, int end) {
		int i;
		for (i = start; i < end; i++) {
			if (inorder.get(i) == num)
				return i;
		}
		return i;
	}

}