package com.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisBalancedOrNot {
	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * int testCases = sc.nextInt(); String[] arr = new String[testCases]; for (int
	 * i = 0; i < arr.length; i++) { arr[i] = sc.next(); } sc.close(); List<Integer>
	 * result = isBalanced(arr); result.stream().forEach(System.out::println); }
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		sc.close();
		System.out.println(solve(A));
	}

	public static int solve(String A) {
		List<Character> starting = new ArrayList<>();
		starting.add('(');
		starting.add('[');
		starting.add('{');
		List<Character> ending = new ArrayList<>();
		ending.add(')');
		ending.add(']');
		ending.add('}');
		int result = 1;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if (starting.contains(A.charAt(i))) {
				stack.push(A.charAt(0));
			} else if (ending.contains(A.charAt(i))) {
				if (!stack.isEmpty())
					stack.pop();
				else {
					result = 0;
					break;
				}

			}
		}
		if (result != 0 && !stack.isEmpty())
			result = 0;
		return result;
	}

	private static List<Integer> isBalanced(String[] arr) {
		List<Integer> resultLst = new ArrayList<>();
		List<Character> starting = new ArrayList<>();
		starting.add('(');
		starting.add('[');
		starting.add('{');
		List<Character> ending = new ArrayList<>();
		ending.add(')');
		ending.add(']');
		ending.add('}');
		for (String str : arr) {
			int result = 1;
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				if (starting.contains(str.charAt(i))) {
					stack.push(str.charAt(0));
				} else if (ending.contains(str.charAt(i))) {
					if (!stack.isEmpty())
						stack.pop();
					else {
						result = 0;
						break;
					}

				}
			}
			if (result != 0 && !stack.isEmpty())
				result = 0;
			resultLst.add(result);
		}
		return resultLst;
	}

}

/**
*

Input
2
(()())
(()

2
"(()())"
"(()"

Output
1
0

2
((((
))))

0
0

*/