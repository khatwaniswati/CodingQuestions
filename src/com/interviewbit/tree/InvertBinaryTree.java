package com.interviewbit.tree;

class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(5);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(7);
		createTree.left = left;
		createTree.right = right;

		TreeNode leftleft = new TreeNode(1);
		TreeNode leftright = new TreeNode(3);
		left.left = leftleft;
		left.right = leftright;

		TreeNode rightleft = new TreeNode(6);
		TreeNode rightright = new TreeNode(9);
		right.left = rightleft;
		right.right = rightright;

		TreeUtility.root = createTree;
		System.out.println(TreeUtility.root.left);
		System.out.println(TreeUtility.root.right);
		TreeNode invertTree = invertTree(createTree);
		TreeUtility.root = invertTree;
		TreeUtility.bfsLevelwise();
		System.out.println(TreeUtility.root.left);
		System.out.println(TreeUtility.root.right);
	}

	public static TreeNode invertTree(TreeNode A) {
		if(A.left==null && A.right==null)
			return A;
		if (A.left != null && A.right != null) {
			TreeNode temp = A.left;
			A.left = A.right;
			A.right = temp;
			A.left =invertTree(A.left);
			A.right =invertTree(A.right);
		} else if (A.left != null && A.right == null) {
			A.right = A.left;
			A.left = null;
			A.right =invertTree(A.right);
		} else if (A.right != null && A.left == null) {
			A.left = A.right;
			A.right = null;
			A.left =invertTree(A.left);
		}
		return A;
	}

}