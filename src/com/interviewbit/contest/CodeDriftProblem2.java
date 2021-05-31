package com.interviewbit.contest;

public class CodeDriftProblem2 {
	public static void main(String[] args) {
		// System.out.println(solve("finger", "ginger", 1));
		// System.out.println(solve("xabcidy", "ycbaidx", 1));
		System.out.println(solve("abceda", "bdecbo", 1));
		//System.out.println(solve("abbacac", "bcacabb", 4));
	}

	public static int solve(String A, String B, int C) {
		int cost = 0;
		int len = A.length();
		int start = -1, end = -1;
		int revS = -1, revE = -1;

		StringBuilder reverseB = new StringBuilder(B);
		reverseB = reverseB.reverse();

		for (int i = 0,j=-1; i < len; i++) {
			if (A.charAt(i) == B.charAt(i)) {
				if (start == -1)
					start = i;
			} else {
				if (start != -1) {
					if (i == start + 1)
						start = -1;
					else
						end = i;
				}
			}
			if(i<len-1 && reverseB.indexOf(""+A.charAt(i)+A.charAt(i+1)) !=-1) {
				j=len-1-reverseB.indexOf(""+A.charAt(i));
			}
			System.out.println(j);
			if (j!=-1 && A.charAt(i) == B.charAt(j)) {
				if (revS == -1)
					revS = i;
			} else {
				if (revS != -1) {
					if (i == revS + 1)
						revS = -1;
					else
						revE = i - 1;
				}
			}
			if(j!=-1)
				j--;
		}
		if (start != -1 && end == -1)
			end = len - 1;
		if (revS != -1 && revE == -1)
			revE = len - 1;
		System.out.println(start + " " + end + " " + revS + " " + revE);
		if (revS != -1) {
			cost += C;
			StringBuilder newStrB = new StringBuilder(B);
			B = newStrB.replace(revS, revE + 1, A.substring(revS, revE + 1)).toString();
			System.out.println(B);
		}

		for (int i = 0; i < len; i++) {
			if (start != -1) {
				cost += (start);
				i = end;
			}
			if (A.charAt(i) != B.charAt(i))
				cost++;
		}

		return cost;
	}
}
