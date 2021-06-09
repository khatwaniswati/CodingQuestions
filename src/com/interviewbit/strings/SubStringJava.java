package com.interviewbit.strings;

import java.util.Scanner;

public class SubStringJava {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int l = sc.nextInt();
		int r = sc.nextInt();
		sc.close();
		System.out.println(str.substring(l, r + 1));
	}
}