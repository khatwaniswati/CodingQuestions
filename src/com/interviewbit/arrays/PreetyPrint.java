package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PreetyPrint {
	public static void main(String[] args) {
		int[][] prettyPrintArray = prettyPrintArray(4);
		for (int i = 0; i < prettyPrintArray.length; i++) {
			System.out.println(Arrays.toString(prettyPrintArray[i]));
		}
		ArrayList<ArrayList<Integer>> prettyPrintLst = prettyPrint(4);
		System.out.println();
		for (ArrayList<Integer> arrayList : prettyPrintLst) {
			System.out.println(arrayList);
		}
	}
	public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int total=A+(A-1);
		for (int i = 0; i < total; i++) {
			ArrayList<Integer> col = new ArrayList<>();
			for (int j = 0; j < total; j++) {
				col.add(-1);
			}
			result.add(col);
		}
		for (int i = 0; i < total; i++) {
			for(int j=i;j<total;j++) {
				if(result.get(i).get(j)==-1) {
					ArrayList<Integer> row = result.get(i);
					row.set(j, A);
				}
			}
			for(int j=i;j<total;j++) {
				if(result.get(j).get(i)==-1) {
					ArrayList<Integer> row = result.get(j);
					row.set(i, A);
				}
			}
			int k=total-1;
			for(int j=i;j<total;j++) {
				if(result.get(j).get(k)==-1) {
					ArrayList<Integer> row = result.get(j);
					row.set(k, A);
				}
			}
			for(int j=i;j<total;j++) {
				if(result.get(k).get(j)==-1) {
					ArrayList<Integer> row = result.get(k);
					row.set(j, A);
				}
			}
			if(A>=1)
				A--;
			else
				A++;
			total=i+2*A;
		}
		return result;
	}
	public static int[][] prettyPrintArray(int A) {
		int total=A+(A-1);
		int[][] result = new int[total][total];
		for (int i = 0; i < total; i++) {
			for(int j=i;j<total;j++) {
				result[i][j]=A;
			}
			for(int j=i;j<total;j++) {
				result[j][i]=A;
			}
			//System.out.println(total+" "+i+" "+A);
			int k=total-1;
			for(int j=i;j<total;j++) {
				result[j][k]=A;
			}
			for(int j=i;j<total;j++) {
				result[k][j]=A;
			}
			if(A>=1)
				A--;
			else
				A++;
			total=i+2*A;
		}
		return result;
	}
}
