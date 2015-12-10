package com.ice.solution;

import java.util.Scanner;
import java.util.TreeSet;

public class SolutionStringSimilarity {
	// TODO All Domains Algorithms Strings String Similarity

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.next()));
		}

		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(String string) {
		char[] chars = string.toCharArray();
		long total = 0;
		for (int a = 0; a < chars.length; a++) {
			if (a == 0) {
				total += chars.length;
			} else if (chars[a] == chars[0]) {
				int temp = a;
				for (char cc : chars) {
					if (temp > chars.length - 1 || cc != chars[temp]) {
						break;
					}
					temp++;
					total++;
				}
			}
		}
		return total;
	}

	private static Object calcRes1(String string) {
		TreeSet<String> strings = new TreeSet<>();
		char[] chars = string.toCharArray();
		long total = 0;
		for (int a = 0; a < chars.length; a++) {
			strings.add(string.substring(a));
		}
		System.out.println(strings);
		TreeSet<String> temps;
		for (int ii = 1; ii <= string.length(); ii++) {
			System.out.println(string.substring(0, ii) + "::" + strings.headSet(string.substring(0, ii), true));
			temps = (TreeSet) strings.headSet(string.substring(0, ii), true);
			if (temps.size() == 0) {
				break;
			}
			total += temps.size();
		}

		return total;
	}
}