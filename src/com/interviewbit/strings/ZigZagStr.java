package com.interviewbit.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagStr {
	public static void main(String[] args) {
		System.out.println(convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 1));
		//System.out.println(convert("ABCDEFGHIJKLMNOPQRS", 6));
		//"PAYPALISHIRING", 3==> PAHNAPLSIIGYIR
		//AKBJLCIMSDHNREGOQFP
		//System.out.println(convert("ABCD", 1));
	}

	/*
	 * public static String convert(String A, int B) { int incr = 0; if (B == 1 || B
	 * == 2) incr = B; else incr = B * 2 - 2; int incrOriginal = incr;
	 * System.out.println(incr); StringBuilder sb = new StringBuilder(); for (int i
	 * = 0; i < B; i++) { int cntr = i; System.out.println(i + " " + incr); int
	 * tempIncr=incr; while (cntr < A.length()) {
	 * System.out.print(cntr+" "+A.charAt(cntr)); sb.append(A.charAt(cntr));
	 * if(cntr==i || incr==i*2) { incr=tempIncr; }else { incr=i*2; } cntr+=incr; }
	 * System.out.println(); if (incr > 2) incr -= 2; else if (incr == 2) incr =
	 * incrOriginal; System.out.println("incr:"+incr); } return sb.toString(); }
	 */
	
	public static String convert(String A, int B) {
		if(B==1)
			return A;
		List<StringBuilder> lst = new ArrayList<>();
		boolean incre=true,decre=false;
		for (int i = 0; i<B; i++) {
			lst.add(new StringBuilder());
		}
		int cntr=0;
		for (int i = 0; i<A.length(); i++) {
			System.out.println(cntr);
			lst.get(cntr).append(A.charAt(i));
			if(incre && cntr<B) {
				cntr++;
				if(cntr==B-1) {
					decre=true;
					incre=false;
				}
			}else if(decre && cntr>0) {
				cntr--;
				if(cntr==0) {
					decre=false;
					incre=true;
				}
			}
		}
		return lst.stream().map(sb->sb.toString()).collect(Collectors.joining());
	}
}
