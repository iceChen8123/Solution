package com.ice.solution;

import java.io.IOException;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SolutionTwoStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			String[] all = new String[2];
			all[0] = in.next();
			all[1] = in.next();
			stringBuilder.append("\n").append(calcRes1(all));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes1(String[] all) {
		TreeSet<Character> chars1 = new TreeSet<>();
		for (char cc : all[0].toCharArray()) {
			chars1.add(cc);
		}
		TreeSet<Character> chars2 = new TreeSet<>();
		for (char cc : all[1].toCharArray()) {
			chars2.add(cc);
		}
		char ccTmp = 'a';
		while (true) {
			NavigableSet<Character> headSetInChars1 = chars1.headSet(ccTmp, true);
			if (headSetInChars1.size() > 0 && headSetInChars1.last() == ccTmp) {
				ccTmp = headSetInChars1.last();
				NavigableSet<Character> headSetInChars2 = chars2.headSet(ccTmp, true);
				if (headSetInChars2.size() > 0 && headSetInChars2.last() == ccTmp) {
					return "YES";
				}
			}
			if (ccTmp == 'z') {
				break;
			}
			NavigableSet<Character> tailSetInChars1 = chars1.tailSet(ccTmp, false);
			if (tailSetInChars1.size() > 0) {
				ccTmp = tailSetInChars1.first();
			} else {
				break;
			}
		}
		return "NO";
	}

}