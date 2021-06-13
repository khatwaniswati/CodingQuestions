package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NTriangles {
	public static void main(String[] args) {
		//System.out.println(nTriang(new ArrayList<>(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12))));
		System.out.println(improvedNTriang(new ArrayList<>(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12))));
		//System.out.println(copied(new ArrayList<>(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12))));
		//System.out.println(copied2(new ArrayList<>(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12))));
		System.out.println(solution(new ArrayList<>(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12))));
		// ArrayList<Integer> A = new ArrayList(Arrays.asList(1,3,4,6,12,13,16,20));
		// int kLeft = findLeftIndexOfKUsingBinarySearch(A, 6, A.size()-1, 17);
		// System.out.println(kLeft);
		// 4, 6, 13, 16, 20, 3, 1, 12-->12
		// 1, 1, 1, 2, 2-->4
		// 1,3,5,8,9,10,11,11,13,20-->53
	}

	public static int solution(ArrayList<Integer> A) {
		if (A == null)
			return 0;
		Collections.sort(A);
		long count = 0l;
		for (int i = 0; i < A.size(); i++) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (A.get(left) + A.get(right) > A.get(i)) {
					// The edge from S[left] to S[right - 1] will also form a triangle
					count += right - left;
					right--;
				} else {
					left++;
				}
			}
		}
		count %= 1000000007;
		return (int) count;
	}

	public static int copied(ArrayList<Integer> A) {
		if (A == null || A.size() == 0) {
			return 0;
		}
		Collections.sort(A);
		int ans = 0;
		for (int k = 2; k < A.size(); k++) {
			for (int i = 0, j = k - 1; i < j;) {
				if (A.get(i) + A.get(j) > A.get(k)) {
					ans += j - i;
					j--;
				} else {
					i++;
				}
			}
		}
		return ans;
	}

	public static int copied2(ArrayList<Integer> A) {
		int n = A.size();
		int res = 0;
		if (n < 3)
			return res;
		int mod = 1000000007;
		Collections.sort(A);

		for (int i = n - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k) {
				long sum = A.get(j) + A.get(k);
				if (sum > A.get(i)) {
					res = (res + (k - j) % mod) % mod;
					k--;
				} else {
					j++;
				}
			}
		}

		return res;
	}

	public static int improvedNTriang(ArrayList<Integer> A) {
		Collections.sort(A);
		int resultCount = 0;
		for (int i = 0; i < A.size() - 2; i++) {
			for (int j = i + 1; j < A.size() - 1; j++) {
				int k = A.get(i) + A.get(j);
				System.out.println(i + " " + j + " " + k);
				int kLeft = findLeftIndexOfKUsingBinarySearch(A, j + 1, A.size() - 1, k);
				if (kLeft < A.size()) {
					int cnt = kLeft - j;
					if (cnt > 0) {
						System.out.println("cnt:" + cnt);
						resultCount += cnt;
					}
				}
			}

		}
		return resultCount;
	}

	private static int findLeftIndexOfKUsingBinarySearch(ArrayList<Integer> A, int left, int right, int searchK) {
		while (right >= left && right < A.size()) {
			int mid = (left + right) / 2;
			if (searchK > A.get(mid))
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println("left::" + left);
		return left - 1;
	}

	public static int nTriang(ArrayList<Integer> A) {
		Collections.sort(A);
		int resultCount = 0;
		for (int i = 0; i < A.size() - 2; i++) {
			int a = i;
			for (int j = i + 1; j < A.size() - 1; j++) {
				int b = j;
				int c = j + 1;
				while (c < A.size()) {
					if (A.get(a) + A.get(b) > A.get(c)) {
						double perimeter = (A.get(a) + A.get(b) + A.get(c)) / 2.0;
						double area = Math.sqrt(perimeter * ((double) perimeter - A.get(a)) * (perimeter - A.get(b))
								* (perimeter - A.get(c)));
						if (area > 0) {
							System.out.println("1:" + a + " 2:" + b + " 3:" + c);
							resultCount++;
						}
					} else
						break;
					c++;
				}
			}
		}
		return resultCount;
	}
}
