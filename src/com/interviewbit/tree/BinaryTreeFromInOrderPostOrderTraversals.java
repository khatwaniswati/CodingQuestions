package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

class BinaryTreeFromInOrderPostOrderTraversals {
	public static void main(String[] args) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(4,8,2,5,1,6,3,7));
		ArrayList<Integer> postOrder = new ArrayList<Integer>(Arrays.asList(8,4,5,2,6,7,3,1));
		System.out.println(buildTree(inOrder,postOrder));
	}

	public static TreeNode buildTree(ArrayList<Integer> inOrder,ArrayList<Integer> postOrder) {
		TreeNode root = new TreeNode(postOrder.get(postOrder.size()-1));

		if (inOrder.size() > 1) {
			ArrayList<Integer> inOrderleftSubTree = new ArrayList<Integer>(
					inOrder.subList(0, inOrder.indexOf(postOrder.get(postOrder.size()-1))));
			ArrayList<Integer> inOrderRightSubTree = new ArrayList<Integer>(
					inOrder.subList(inOrder.indexOf(postOrder.get(postOrder.size()-1)) + 1, inOrder.size()));

			if (inOrderleftSubTree.size() == 1) {
				root.left = new TreeNode(inOrderleftSubTree.get(0));
			} else if (inOrderleftSubTree.size() != 0) {
				int rightIndexPostOrder=inOrderleftSubTree.size();
				ArrayList<Integer> postOrderLeftSubTree = new ArrayList<Integer>(
						postOrder.subList(0,rightIndexPostOrder));
				root.left = buildTree(inOrderleftSubTree,postOrderLeftSubTree);
			}

			if (inOrderRightSubTree.size() == 1) {
				root.right = new TreeNode(inOrderRightSubTree.get(0));
			} else if (inOrderRightSubTree.size() != 0) {
				int leftIndexPostOrder=postOrder.size()-1-inOrderRightSubTree.size();
				ArrayList<Integer> postOrderRightSubTree = new ArrayList<Integer>(
						postOrder.subList(leftIndexPostOrder,postOrder.size()-1));
				root.right = buildTree(inOrderRightSubTree,postOrderRightSubTree);
			}
		}

		return root;
	}

}