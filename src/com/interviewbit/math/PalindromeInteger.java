package com.interviewbit.math;

public class PalindromeInteger {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12121));
		System.out.println(isPalindrome(1232));
		System.out.println(isPalindrome(-1232));
	}

	public static int isPalindrome(int A) {
		if(A<0)
			return 0;
		String s = new String(A+"");
		int start=0,end=s.length()-1;
		while(start<end) {
			if(s.charAt(start)==s.charAt(end)) {
				start++;
				end--;
			}else {
				return 0;
			}
		}
		return 1;
	}
}
