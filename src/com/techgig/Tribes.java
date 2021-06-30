package com.techgig;

import java.text.DecimalFormat;
import java.util.Scanner;

/* Read input from STDIN. Print your output to STDOUT*/

public class Tribes {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		sc.close();

		DecimalFormat df = new DecimalFormat("#.#####");
		double total = r + s + p;
		String rP = df.format(r / total);
		String sP = df.format(s / total);
		String pP = df.format(p / total);
		System.out.println(rP + " " + sP + " " + pP);
	}
}
