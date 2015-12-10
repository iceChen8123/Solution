package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SolutionSherlockAndSquares {

	static TreeSet<Long> sCache = new TreeSet<>();

	static long lastCalc = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.nextInt(), in.nextInt()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int from, int to) {
		if (sCache.tailSet((long) to).size() <= 0) {
			for (long a = lastCalc;; a++) {
				long aa = a * a;
				sCache.add(aa);
				if (aa > to) {
					lastCalc = a;
					break;
				}
			}
		}
		SortedSet<Long> headSetForTo = new TreeSet<>(sCache.headSet((long) to, true));
		headSetForTo.removeAll(sCache.headSet((long) from));
		return headSetForTo.size();
	}
}