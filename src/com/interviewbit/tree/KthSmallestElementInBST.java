package com.interviewbit.tree;

import java.util.Arrays;
import java.util.Stack;

public class KthSmallestElementInBST {

	public static void main(String[] args) {
		/*
		 * TreeNode createBinarySearchTree =
		 * TreeUtility.createBinarySearchTree(Arrays.asList(2,1,3));
		 * System.out.println(kthsmallest(createBinarySearchTree, 2));
		 */
		
		TreeNode createBinarySearchTree1 = TreeUtility.createBinarySearchTree(Arrays.asList(50,30,90,10,40,70,100,20,60,80));
		System.out.println(kthsmallest(createBinarySearchTree1, 4));
	}

	public static int kthsmallest(TreeNode A, int B) {
		Stack<TreeNode> stack = new Stack<>();
		int count=0;
		TreeNode trav = A;
		int result=0;
		while(trav!=null || !stack.isEmpty()) {
			while(trav!=null) {
				stack.push(trav);
				trav=trav.left;
			}
			if(!stack.isEmpty()) {
				TreeNode poppedNode = stack.pop();
				//System.out.println(poppedNode.val);
				count++;
				if(count==B) {
					result= poppedNode.val;
					return result;
				}
				trav=poppedNode.right;
			}
		}
		return result;
	}

}