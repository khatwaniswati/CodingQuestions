package com.interviewbit.arrays;

import java.util.ArrayList;

public class SpiralArray {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		ArrayList<Integer> arrayList = new ArrayList();
		arrayList.add(1);arrayList.add(2);arrayList.add(3);
		lst.add(arrayList);
		arrayList = new ArrayList();
		arrayList.add(4);arrayList.add(5);arrayList.add(6);
		lst.add(arrayList);
		arrayList = new ArrayList();
		arrayList.add(7);arrayList.add(8);arrayList.add(9);
		lst.add(arrayList);
		System.out.println(lst);
		ArrayList<Integer> spiralOrder = spiralOrder(lst);
		System.out.println(spiralOrder);
	}

	public static ArrayList<Integer> spiralOrder(final ArrayList<ArrayList<Integer>> A) {
		ArrayList<Integer> result = new ArrayList<>();
		int top=0,bottom=A.size()-1,left=0,right=A.get(0).size()-1;
		//System.out.println(top+" "+bottom+" "+left+" "+right);
		int dir=0;
		while(top<=bottom && left<=right) {
			if(dir==0) {
				//left to right (top row)
				for(int i=left;i<=right;i++) {
					result.add(A.get(top).get(i));
				}
				dir=1;
				top++;
			}else if(dir==1) {
				//top to bottom (rightmost row)
				for(int i=top;i<=bottom;i++) {
					result.add(A.get(i).get(right));
				}
				dir=2;
				right--;
			}else if(dir==2) {
				//right to left (bottom-most row)
				for(int i=right;i>=left;i--) {
					result.add(A.get(bottom).get(i));
				}
				dir=3;
				bottom--;
			}else if(dir==3) {
				//bottom to top (leftmost row)
				for(int i=bottom;i>=top;i--) {
					result.add(A.get(i).get(left));
				}
				dir=0;
				left++;
			}
		}
		return result;
	}
}
