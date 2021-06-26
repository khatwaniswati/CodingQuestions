package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidBSTFromPreOrder {
	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<>(Arrays.asList(7, 7, 10, 10, 9, 5, 2, 8))));
		System.out.println(solve(new ArrayList<>(Arrays.asList(7, 7, 10, 10, 9, 5, 2, 8))));
	}

	public static int solve(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		int root=Integer.MIN_VALUE;
		for (Integer element : A) {
			if(element<root)
				return 0;

			while(!stack.isEmpty() && stack.peek()<element) {
				root=stack.peek();
				stack.pop();
			}
			stack.push(element);
		}
		return 1;
	}
}
