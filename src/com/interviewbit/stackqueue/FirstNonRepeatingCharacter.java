package com.interviewbit.stackqueue;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		sc.close();
		System.out.println(optimizedSolve(A));
	}

	public static String solve(String A) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= A.length(); i++) {
			sb.append(findFirstNonRepeatingCharacter(A.substring(0, i)));
		}
		return sb.toString();
	}

	public static String optimizedSolve(String A) {
		Queue<Character> queue = new LinkedList<>();
		int[] countArr = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			queue.offer(A.charAt(i));
			countArr[(int) A.charAt(i) % 97]++;
			boolean flag = false;
			while (!queue.isEmpty()) {
				char peeked = queue.peek();
				if (countArr[(int) peeked % 97] == 1) {
					sb.append(peeked);
					flag = true;
					break;
				} else {
					queue.poll();
				}
			}
			if (!flag)
				sb.append("#");
		}
		return sb.toString();
	}

	private static char findFirstNonRepeatingCharacter(String substring) {
		Map<Character, Entry<Integer, Integer>> indexCountForCharacter = new LinkedHashMap<>();
		for (int j = 0; j < substring.length(); j++) {
			if (indexCountForCharacter.containsKey(substring.charAt(j))) {
				Entry<Integer, Integer> pair = indexCountForCharacter.get(substring.charAt(j));
				Integer count = pair.getValue();
				indexCountForCharacter.put(substring.charAt(j),
						new AbstractMap.SimpleEntry<>(pair.getKey(), count + 1));
			} else {
				indexCountForCharacter.put(substring.charAt(j), new AbstractMap.SimpleEntry<>(j, 1));
			}
		}
		Optional<Entry<Character, Entry<Integer, Integer>>> findFirst = indexCountForCharacter.entrySet().stream()
				.filter(e -> e.getValue().getValue() == 1).findFirst();
		return findFirst.isPresent()
				? indexCountForCharacter.entrySet().stream().filter(e -> e.getValue().getValue() == 1).findFirst().get()
						.getKey()
				: '#';
	}
}
