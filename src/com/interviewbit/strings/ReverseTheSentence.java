package com.interviewbit.strings;

import java.util.StringJoiner;

public class ReverseTheSentence {

	public static void main(String[] args) {
		//String A = "the sky is blue";
		//String A = "this is ib";
		String A = "       fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ";
		System.out.println(solve(A));
	}

	public static String solve(String A) {
		String[] split = A.split("\\s+");
		int start=0,end=split.length-1;
		while(start<end) {
			String temp = split[start];
			split[start] = split[end];
			split[end]=temp;
			start++;
			end--;
		}
		StringJoiner s = new StringJoiner(" ");
		for (String string : split) {
			s.add(string);
		}
		return s.toString().trim();
	}

}