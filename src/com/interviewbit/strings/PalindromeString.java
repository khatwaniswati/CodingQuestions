package com.interviewbit.strings;
public class PalindromeString {
	public static void main(String[] args) {
		//String s = "A man, a plan, a canal: Panama";
		String s = "race a car";
		System.out.println(isPalindrome(s));
	}
    public static int isPalindrome(String A) {
    	int result =0;
    	String newA = A.replaceAll("[^a-zA-Z0-9]", "");
    	StringBuilder reverse = new StringBuilder(newA);
    	if(reverse.reverse().toString().equalsIgnoreCase(newA)) {
    		result=1;
    	}
    	return result;
    }
}
