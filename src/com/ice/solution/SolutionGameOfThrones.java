package com.ice.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionGameOfThrones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n").append(calcRes(in.next()));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(String string) {
		Map<Character, Integer> counterMap = new HashMap<Character, Integer>();
		for (char cc : "qwertyuiopasdfghjklzxcvbnm".toCharArray()) {
			counterMap.put(cc, 0);
		}
		for (char cc : string.toCharArray()) {
			counterMap.put(cc, counterMap.get(cc) + 1);
		}
		int oddNum = 0;
		for (Integer ii : counterMap.values()) {
			oddNum += ii % 2;
		}
		if (oddNum < 2) {
			return "YES";
		} else {
			return "NO";
		}
	}
}