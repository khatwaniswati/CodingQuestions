package com.interviewbit.tree;

class LeastCommonAncestor {

	public static void main(String[] args) {
		TreeNode createTree = new TreeNode(3);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(1);
		createTree.left = left;
		createTree.right = right;

		TreeNode nextleft = new TreeNode(6);
		left.left = nextleft;
		TreeNode nextright = new TreeNode(2);
		left.right = nextright;

		TreeNode nextLeftLeft = new TreeNode(7);
		nextright.left = nextLeftLeft;
		TreeNode nextLeftRight = new TreeNode(4);
		nextright.right = nextLeftRight;

		TreeNode rightLeft = new TreeNode(0);
		right.left = rightLeft;
		TreeNode rightRight = new TreeNode(8);
		right.right = rightRight;

		System.out.println(createTree);
		System.out.println(lca(createTree, left.val, 10));
	}

	static int c;

	public static int lca(TreeNode root, int B, int C) {
		c = 0;
		TreeNode node = check(root, B, C);
		if (c == 2 || (B == C && c == 1)) {
			return node.val;
		}
		return -1;
	}

	static TreeNode check(TreeNode root, int B, int C) {
		if (root == null)
			return null;
		TreeNode l = check(root.left, B, C);
		TreeNode r = check(root.right, B, C);
		if (root.val == B || root.val == C) {
			c++;
			return root;
		}
		if (l != null && r != null)
			return root;
		if (l == null)
			return r;
		return l;
	}

	public static int mylca(TreeNode A, int B, int C) {
		if (A == null)
			return -1;

		if (A.val == B || A.val == C)
			return A.val;

		int left = mylca(A.left, B, C);
		int right = mylca(A.right, B, C);
		System.out.println(left + " >>>" + right);
		if (left != -1 && right != -1)
			return A.val;

		if (left != -1)
			return left;

		if (right != -1)
			return right;

		return -1;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;

		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;

		if (left != null)
			return left;

		if (right != null)
			return right;

		return null;
	}

	public static TreeNode lowestCommonAncestorCopy(TreeNode root, TreeNode p, TreeNode q) {
		// The logic is to recursively do DFS and find either P or Q
		// Try to find P or Q and propagate up.
		// If currentNode is P or Q we return(propagate up) currentNode
		// If we find P and Q from left and right subtrees both, propagate up
		// CurrentNode since currentNode will be LCA.
		// Else propagate up either leftTree or rightSubtree which ever is non null.

		// if root is null
		if (root == null)
			return root;

		// if the current node is p or q return curentnode
		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// if both left and right subtree are non null
		// then the current node is the LCA
		if (left != null && right != null)
			return root;

		if (left != null)
			return left;

		if (right != null)
			return right;

		return null;
	}
}