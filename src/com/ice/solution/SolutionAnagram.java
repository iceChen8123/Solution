package com.ice.solution;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionAnagram {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < n; a0++) {
			stringBuilder.append("\n").append(calcRes(in.next()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(String string) {
		if (string.length() % 2 != 0) {
			return -1;
		}
		char[] s1 = string.substring(0, string.length() / 2).toCharArray();
		char[] s2 = string.substring(string.length() / 2).toCharArray();
		Map<Character, Integer> s1Map = new HashMap<Character, Integer>();
		Map<Character, Integer> s2Map = new HashMap<Character, Integer>();
		for (char cc : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
			s1Map.put(cc, 0);
			s2Map.put(cc, 0);
		}
		for (int a = 0; a < s1.length; a++) {
			s1Map.put(s1[a], s1Map.get(s1[a]) + 1);
			s2Map.put(s2[a], s2Map.get(s2[a]) + 1);
		}
		int count = 0;
		for (char cc : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
			count += Math.abs(s1Map.get(cc) - s2Map.get(cc));
		}
		return count / 2;
	}
}